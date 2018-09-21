package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.entity.pojo.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.modal.SysPermissionExample;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.blessedbin.frame.ucenter.modal.SysPermission.TYPE_API;

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
public class ApiService {


    @Autowired
    private PermissionService permissionService;

    @Autowired
    private DocumentationCache documentationCache;

    @Autowired
    private ServiceModelToSwagger2Mapper swagger2mapper;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * 扫描API列表
     */
    @Transactional(rollbackFor = Exception.class)
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

                String code = TYPE_API + ":" + applicationName + ":" + operation.getOperationId();

                SysPermission prePermission = permissionService.selectByIdentification(code);
                try {
                    if(prePermission == null){
                        // 新的点，插入
                        SysPermission permission = buildPermission(operation, code);
                        SysApi api = buildApi(url, httpMethod, operation, permission.getPermissionId());
                        permission.setAdditionInformation(objectMapper.writeValueAsString(api));
                        permissionService.insertSelective(permission);

                        log.debug("插入新的API：{}-{}",permission.getCode(),api);
                        addPoint.addAndGet(1);
                    } else {
                        // 判断信息是否相同，不相同则更新，相同则跳过
                        SysApi preAPi = objectMapper.readValue(prePermission.getAdditionInformation(),SysApi.class);
                        SysApi api = buildApi(url, httpMethod, operation, prePermission.getPermissionId());

                        SysPermission buildPermission = buildPermission(operation, code);
                        buildPermission.setPermissionId(prePermission.getPermissionId());

                        if(!buildPermission.equals(prePermission) || !api.equals(preAPi)){
                            SysPermission nPermission = new SysPermission();
                            nPermission.setName(operation.getSummary());
                            nPermission.setPermissionId(prePermission.getPermissionId());
                            nPermission.setUpdateTime(new Date());

                            nPermission.setAdditionInformation(objectMapper.writeValueAsString(api));

                            permissionService.updateByPkSelective(nPermission);

                            log.debug("更新api {}：{}->{}",prePermission.getCode(),preAPi,api);

                            updatePoint.addAndGet(1);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        });

        log.debug(">>> 新增权限点{}个，更新权限点{}个",addPoint.get(),updatePoint.get());
    }

    private SysApi buildApi(String url, HttpMethod httpMethod, Operation operation, Integer permissionId) {
        SysApi api = new SysApi();
        api.setId(permissionId);
        api.setDescription(operation.getDescription());
        api.setName(operation.getSummary());
        api.setUrl(url);
        api.setMethod(httpMethod.name());
        api.setTags(StringUtils.collectionToDelimitedString(operation.getTags(),","));
        api.setSort(1);
        return api;
    }

    private SysPermission buildPermission(Operation operation, String code) {
        SysPermission permission = new SysPermission();
        permission.setEnabled(true);
        permission.setSort(1);
        permission.setType(TYPE_API);
        permission.setName(operation.getSummary());
        permission.setCreateTime(new Date());
        permission.setUpdateTime(new Date());
        permission.setCode(code);
        return permission;
    }


    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Pagination<SysApi> getDataTables(Integer pageNum, Integer pageSize) {
        SysPermissionExample example = new SysPermissionExample();
        example.createCriteria().andTypeEqualTo(TYPE_API);
        Pagination<SysPermission> dataTable = permissionService.getDataTable(pageNum, pageSize, example);
        List<SysApi> collect = dataTable.getData().stream().map(this::toSysApi).collect(Collectors.toList());
        return new Pagination<SysApi>(dataTable.getCurrentPage(),dataTable.getPageSize(),
                dataTable.getTotal(),collect);
    }

    /**
     * @param uuid
     * @return
     */
    public List<SysApi> selectByUuid(String uuid) {
        return null;
    }

    public List<SysApi> selectByMenuId(Integer menuId) {
        return null;
    }

    public List<SysApi> selectAll() {
        List<SysPermission> permissions = permissionService.selectByType(TYPE_API);
        return permissions.stream().map(this::toSysApi).collect(Collectors.toList());
    }

    public SysApi selectByPk(Integer permissionId) {
        return null;
    }

    public SysApi getApi(Integer integer) {
        SysPermission permission = permissionService.selectByPkAndType(integer, TYPE_API);
        if(permission == null) {
            throw new ParamCheckRuntimeException();
        }
        return toSysApi(permission);
    }

    public List<SysApi> getApis(List<Integer> ids) {
        List<SysPermission> permissions = permissionService.selectByPksAndType(ids, TYPE_API);
        return permissions.stream().map(this::toSysApi).collect(Collectors.toList());
    }

    private SysApi toSysApi(SysPermission permission) {
        try {
            SysApi sysApi = objectMapper.readValue(permission.getAdditionInformation(), SysApi.class);
            sysApi.setId(permission.getPermissionId());
            return sysApi;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
