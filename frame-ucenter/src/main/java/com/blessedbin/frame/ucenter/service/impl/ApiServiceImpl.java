package com.blessedbin.frame.ucenter.service.impl;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.entity.dto.ApiDto;
import com.blessedbin.frame.ucenter.mapper.SysApiMapper;
import com.blessedbin.frame.ucenter.mapper.SysPermissionMapper;
import com.blessedbin.frame.ucenter.modal.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.service.ApiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
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
public class ApiServiceImpl extends AbstractMysqlCrudServiceImpl<SysApi,Integer>implements ApiService {


    @Autowired
    private SysApiMapper apiMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Autowired
    private DocumentationCache documentationCache;

    @Autowired
    private ServiceModelToSwagger2Mapper swagger2mapper;


    /**
     * 扫描API列表
     */
    @Override@Transactional(rollbackFor = Exception.class)
    public void scanApi() {
        AtomicInteger addPoint = new AtomicInteger();
        AtomicInteger updatePoint = new AtomicInteger();

        Documentation documentation = documentationCache.documentationByGroup(Docket.DEFAULT_GROUP_NAME);
        Swagger swagger = swagger2mapper.mapDocumentation(documentation);

        swagger.getPaths().keySet().forEach(url -> {
            Path path = swagger.getPaths().get(url);
            Map<HttpMethod, Operation> operations = path.getOperationMap();

            operations.keySet().forEach(httpMethod -> {
                Operation operation = operations.get(httpMethod);

                String permissionKey = SysPermission.TYPE_API + "_" + operation.getOperationId();

                SysPermission prePermission = permissionMapper.selectByPermissionKey(permissionKey);
                if(prePermission == null){
                    // 新的点，插入
                    SysPermission permission = buildPermission(operation, permissionKey);
                    permissionMapper.insertSelective(permission);

                    SysApi api = buildApi(url, httpMethod, operation, permission.getId());
                    apiMapper.insert(api);
                    log.debug("插入新的API：{}-{}",permission.getPermissionKey(),api);
                    addPoint.addAndGet(1);
                } else {
                    // 判断信息是否相同，不相同则更新，相同则跳过
                    SysApi preAPi = apiMapper.selectByPrimaryKey(prePermission.getId());
                    SysApi api = buildApi(url, httpMethod, operation, prePermission.getId());

                    SysPermission buildPermission = buildPermission(operation, permissionKey);
                    buildPermission.setId(prePermission.getId());

                    if(!buildPermission.equals(prePermission) || !api.equals(preAPi)){
                        SysPermission nPermission = new SysPermission();
                        nPermission.setPermissionName(operation.getSummary());
                        nPermission.setId(prePermission.getId());
                        nPermission.setUpdateTime(new Date());
                        permissionMapper.updateByPrimaryKeySelective(nPermission);

                        SysApi nApi = new SysApi();
                        nApi.setTags(StringUtils.collectionToDelimitedString(operation.getTags(),","));
                        nApi.setName(operation.getSummary());
                        nApi.setDescription(operation.getDescription());
                        nApi.setPermissionId(prePermission.getId());
                        nApi.setUpdateTime(new Date());
                        nApi.setUrl(url);
                        nApi.setMethod(httpMethod.name());
                        apiMapper.updateByPrimaryKeySelective(nApi);
                        log.debug("更新api {}：{}->{}",prePermission.getPermissionKey(),preAPi,nApi);

                        updatePoint.addAndGet(1);
                    }

                }
            });

        });

        log.debug(">>> 新增权限点{}个，更新权限点{}个",addPoint.get(),updatePoint.get());
    }

    private SysApi buildApi(String url, HttpMethod httpMethod, Operation operation, Integer permissionId) {
        SysApi api = new SysApi();
        api.setUpdateTime(new Date());
        api.setPermissionId(permissionId);
        api.setCreateTime(new Date());
        api.setDescription(operation.getDescription());
        api.setName(operation.getSummary());
        api.setUrl(url);
        api.setMethod(httpMethod.name());
        api.setTags(StringUtils.collectionToDelimitedString(operation.getTags(),","));
        api.setSort(1);
        return api;
    }

    private SysPermission buildPermission(Operation operation, String permissionKey) {
        SysPermission permission = new SysPermission();
        permission.setEnabled(true);
        permission.setSort(1);
        permission.setType(SysPermission.TYPE_API);
        permission.setPermissionName(operation.getSummary());
        permission.setSysSystemId("user_center");
        permission.setCreateTime(new Date());
        permission.setUpdateTime(new Date());
        permission.setPermissionKey(permissionKey);
        return permission;
    }


    /**
     * TODO  查询优化
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
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

    /**
     * @param uuid
     * @return
     */
    @Override
    public List<SysApi> selectByUuid(String uuid) {
        return apiMapper.selectByUuid(uuid);
    }

    @Override
    public List<SysApi> selectByMenuId(Integer menuId) {
        List<SysApi> apis = apiMapper.selectByMenuId(menuId);
        return apis;
    }
}
