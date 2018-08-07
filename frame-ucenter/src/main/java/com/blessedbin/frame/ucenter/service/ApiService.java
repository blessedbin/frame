package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.component.ApiScanner;
import com.blessedbin.frame.ucenter.component.FrameApiInfo;
import com.blessedbin.frame.ucenter.entity.dto.ApiDto;
import com.blessedbin.frame.ucenter.mapper.SysApiMapper;
import com.blessedbin.frame.ucenter.mapper.SysPermissionMapper;
import com.blessedbin.frame.ucenter.modal.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/10.
 *
 * @author 37075
 * @date 2018/7/10
 * @time 9:31
 * @tool intellij idea
 */
@Service
@Log4j2
public class ApiService extends AbstractMysqlCrudServiceImpl<SysApi,Integer> {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private SysApiMapper apiMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 扫描API列表
     */
    @Transactional(rollbackFor = Exception.class)
    public void scanApi() {

        List<FrameApiInfo> apiInfoList = ApiScanner.scan(requestMappingHandlerMapping);
        AtomicInteger addPoint = new AtomicInteger();
        AtomicInteger updatePoint = new AtomicInteger();

        log.debug("获取到{}条API信息", apiInfoList.size());
        apiInfoList.forEach(api -> {
            log.debug("aip info:{}",api);

            SysPermission permission = permissionMapper.selectByPermissionKey(api.getKey());
            if(permission == null){
                // 新插入
                SysPermission nPermission = buildPermission(api);
                nPermission.setCreateTime(new Date());
                nPermission.setUpdateTime(new Date());
                permissionMapper.insertSelective(nPermission);

                SysApi mapping = buildSysApi(api);
                mapping.setCreateTime(new Date());
                mapping.setUpdateTime(new Date());
                mapping.setPermissionId(nPermission.getId());
                apiMapper.insertSelective(mapping);
                addPoint.addAndGet(1);
                log.debug(">>> 新增权限点:{},{}",nPermission.getPermissionName(), mapping.getUrls());
            }else {
                SysApi preApi = apiMapper.selectByPrimaryKey(permission.getId());

                SysPermission nPermission = buildPermission(api);
                nPermission.setUpdateTime(new Date());
                nPermission.setId(permission.getId());

                SysApi nApi = buildSysApi(api);
                nApi.setPermissionId(permission.getId());
                nApi.setUpdateTime(new Date());
                if(!preApi.equals(nApi) || !permission.equals(nPermission)){
                    permissionMapper.updateByPrimaryKeySelective(nPermission);
                    apiMapper.updateByPrimaryKeySelective(nApi);
                    updatePoint.addAndGet(1);
                    log.debug(">>> 更新权限点:{},{}",permission.getPermissionName(), api.getUrls());
                }
            }

        });
        log.debug(">>> 新增权限点{}个，更新权限点{}个",addPoint.get(),updatePoint.get());
    }

    private SysApi buildSysApi(FrameApiInfo api) {
        SysApi nApi = new SysApi();

        nApi.setUrls(buildUrls(api));
        nApi.setMethodTypes(buildMethods(api));

        RequestParams requestParams = new RequestParams(api).invoke();

        nApi.setMethodParamNames(requestParams.getMethodParamNames());
        nApi.setMethodParamTypes(requestParams.getMethodParamTypes());
        nApi.setMethodName(api.getMethodName());
        nApi.setName(api.getSingleUrl());
        nApi.setControllerName(api.getControllerName());
        nApi.setDescription(api.getDescription());

        return nApi;
    }

    private String buildMethods(FrameApiInfo api) {
        StringBuilder methodBuilder = new StringBuilder();
        boolean isFirst = true;
        for (RequestMethod method : api.getRequestMethods()) {
            if(!isFirst){
                methodBuilder.append(",");
            }
            isFirst = false;
            methodBuilder.append(method);
        }
        return methodBuilder.toString();
    }

    private String buildUrls(FrameApiInfo api) {
        StringBuilder urlBuilder = new StringBuilder();
        boolean isFirst = true;
        for (String url : api.getUrls()) {
            if(!isFirst){
                urlBuilder.append(",");
            }
            isFirst = false;
            urlBuilder.append(url);
        }
        ;
        return urlBuilder.toString();
    }

    /**
     *  构建permission
     * @param apiInfo
     * @return
     */
    private SysPermission buildPermission(FrameApiInfo apiInfo) {
        SysPermission permission = new SysPermission();
        permission.setType(SysPermission.TYPE_API);
        permission.setSort(1);
        permission.setPermissionName(apiInfo.getName());
        permission.setEnabled(true);
        permission.setCreateTime(new Date());
        // ucenter id 写死了
        permission.setSysSystemId("user_center");
        permission.setPermissionKey(apiInfo.getKey());

        permission.setRemark(apiInfo.getDescription());

        return permission;
    }

    /**
     * TODO  查询优化
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Pagination<ApiDto> getDataTables(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysApi> sysApis = mapper.selectAll();
        PageInfo<SysApi> pageInfo = new PageInfo<SysApi>(sysApis);
        List<ApiDto> collect = sysApis.stream().map(api -> {
            SysPermission permission = permissionMapper.selectByPrimaryKey(api.getPermissionId());
            ApiDto dto = new ApiDto();
            BeanUtils.copyProperties(permission, dto);
            BeanUtils.copyProperties(api, dto);
            return dto;
        }).collect(Collectors.toList());
        return new Pagination<ApiDto>(pageInfo.getPageNum(),pageInfo.getPageSize(),
                pageInfo.getTotal(),collect);
    }

    public List<SysApi> selectByUuid(String uuid) {
        return apiMapper.selectByUuid(uuid);
    }


    private class RequestParams {
        private FrameApiInfo pm;
        private String methodParamNames;
        private String methodParamTypes;

        RequestParams(FrameApiInfo pm) {
            this.pm = pm;
        }

        String getMethodParamNames() {
            return methodParamNames;
        }

        String getMethodParamTypes() {
            return methodParamTypes;
        }

        RequestParams invoke() {
            AtomicBoolean paramIsFirst = new AtomicBoolean(true);
            StringBuilder paramNameBuilder = new StringBuilder();
            StringBuilder paramTypeBuilder = new StringBuilder();
            pm.getParams().forEach((s, aClass) -> {
                if(!paramIsFirst.get()){
                    paramNameBuilder.append(",");
                    paramTypeBuilder.append(",");
                }
                paramIsFirst.set(false);
                paramNameBuilder.append(s);
                paramTypeBuilder.append(aClass.getName());
            });
            methodParamNames = paramNameBuilder.toString();
            methodParamTypes = paramTypeBuilder.toString();
            return this;
        }
    }
}
