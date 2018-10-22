package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.entity.FramePermission;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.ui.SelectNode;
import com.blessedbin.frame.ucenter.entity.pojo.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.service.ApiService;
import com.blessedbin.frame.ucenter.service.PermissionService;
import com.blessedbin.frame.ucenter.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 16:47
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/api")
@Api(description = "API列表")
@Log4j2
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 扫描
     */
    @GetMapping("/scan")
    @ApiOperation(value = "更新API列表", notes = "扫描并更新API列表")
    public SimpleResponse scan() {
        apiService.scanApi();
        return SimpleResponse.accepted();
    }

    @GetMapping("/datatable.json")
    public SimpleResponse<Pagination<SysApi>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                       @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                       @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue,
                                                       @RequestParam(name = "tags",required = false,defaultValue = "") String tags) {
        Pagination<SysApi> dataTable = apiService.getDataTables(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }

    /**
     * 获取API标签列表
     * @return
     */
    @GetMapping("/tag_options.json")
    public SimpleResponse tagOptions(){
        Set<String> tags = new HashSet<>();
        apiService.selectAll().forEach(api -> {
            if(!StringUtils.isEmpty(api.getTags())){
                tags.addAll(Arrays.asList(api.getTags().split(",")));
            }
        });
        List<SelectNode> collect = tags.stream().map(tag -> SelectNode.builder().label(tag).value(tag).build()).collect(Collectors.toList());
        return SimpleResponse.ok(collect);
    }

    @GetMapping
    @ApiOperation("获取API信息")
    public SimpleResponse<Object> getAPi(@RequestParam String id,
                       @RequestParam(required = false,defaultValue = "false") Boolean array) {
        List<Integer> ids = Arrays.stream(id.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
        if(ids.isEmpty()) {
            throw new ParamCheckRuntimeException("参数错误");
        }
        if(ids.size() == 1 && !array){
            SysApi operation = apiService.getApi(ids.get(0));
            return SimpleResponse.ok(operation);
        } else {
            List<SysApi> operations = apiService.getApis(ids);
            return SimpleResponse.ok(operations);
        }
    }

    /**
     *
     * @param roleId 角色ID
     * @param menuId
     * @return
     */
    @GetMapping("/select_option.json")
    @ApiOperation(value = "select_option")
    public SimpleResponse<Map<String, Object>> selectList(@RequestParam(required = false) Integer roleId,
                                                          @RequestParam(required = false) Integer menuId){
        Map<String, Object> returnData = new HashMap<>();

        List<SysApi> apis = apiService.selectAll();

        Set<String> tags = new HashSet<>();
        apis.forEach(api -> {
            String apiTags = api.getTags();
            if(!StringUtils.isEmpty(apiTags)){
                tags.addAll(Arrays.asList(apiTags.split(",")));
            }
        });

        List<Map> options = new ArrayList<>();
        tags.forEach(s -> {
            Map<String,Object> groupApi = new HashMap<>();
            List<SysApi> tagApi = apis.stream()
                    .filter(sysApi -> Arrays.asList(sysApi.getTags().split(",")).contains(s))
                    .collect(Collectors.toList());
            groupApi.put("tag",s);
            groupApi.put("list",tagApi);
            options.add(groupApi);
        });
        returnData.put("options", options);

        if (roleId != null) {
            if (!roleService.checkExistsByPk(roleId)) {
                throw new ParamCheckRuntimeException();
            }
            List<SysPermission> sysPermissions = permissionService.selectByRoleIdAndType(roleId);
            List<Map<String, String>> selectedList = sysPermissions.stream().map(permission -> {
                SysApi api = apiService.selectByPk(permission.getPermissionId());
                Map<String, String> data = new HashMap<>();
                data.put("label", permission.getName());
                data.put("value", String.valueOf(api.getId()));
                return data;
            }).collect(Collectors.toList());
            returnData.put("selected", selectedList);
        } else if(menuId != null){
            List<String> selectedList = apiService.selectByMenuId(menuId).stream()
                    .map(api -> String.valueOf(api.getId()))
                    .collect(Collectors.toList());
            returnData.put("selected", selectedList);
        }

        return SimpleResponse.ok(returnData);
    }


    @GetMapping("/findUserApi/{uuid}")
    @ApiIgnore
    public List<FramePermission> findUserApiByUuid(@PathVariable("uuid") String uuid){
        List<SysApi> apis = apiService.selectByUuid(uuid);
        return apis.stream().map(sysApi ->
                FramePermission.builder().method(sysApi.getMethod()).url(sysApi.getUrl()).build())
                .collect(Collectors.toList());
    }


    @GetMapping("/test")
    public OpenAPI test() {
        OpenAPI openAPI = new OpenAPIV3Parser().read("http://localhost:8081/v2/api-docs");

        for( String s :  discoveryClient.getServices()) {
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
            for (ServiceInstance si : serviceInstances) {
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }
        }

        return openAPI;
    }
}
