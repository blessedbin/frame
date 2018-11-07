package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.entity.pojo.Operation;
import com.blessedbin.frame.ucenter.service.OperationService;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/8/3.
 *
 * @author 37075
 * @date 2018/8/3
 * @time 13:38
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/operation")
@Log4j2
public class OperationController {

    @Autowired
    private OperationService operationService;

    /**
     * 添加功能点
     * @param param
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加功能点")
    public SimpleResponse add(@RequestBody @Validated AddActionParam param) {
        operationService.addOperation(param.getMenuId(),param.getName(),param.getRemark());
        return SimpleResponse.created();
    }


    /**
     * 获取operation详情
     * @param id operation 的id
     * @param array 是否强制返回array
     * @return
     */
    @GetMapping
    @ApiOperation(value = "获取operation详情")
    public SimpleResponse<Object> getOperation(@RequestParam String id,
                                               @RequestParam(required = false,defaultValue = "false") Boolean array) {

        List<Integer> ids = Arrays.stream(id.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
        if(ids.isEmpty()) {
            throw new ParamCheckRuntimeException("参数错误");
        }
        if(ids.size() == 1 && !array){
            Operation operation = operationService.getOperation(ids.get(0));
            return SimpleResponse.ok(operation);
        } else {
            List<Operation> operations = operationService.getOperations(ids);
            return SimpleResponse.ok(operations);
        }
    }

    /**
     * 保存功能点与api的关系
     */
    @PostMapping("/edit_operation_api.do")
    @ApiOperation(value = "保存功能点与api的关系")
    public SimpleResponse editOperationApi(@RequestBody @Validated EditOperationApiParam param){
        log.debug("request param:{}",param);
        Operation operation = operationService.getOperation(param.getOperationId());
        if(operation == null){
            throw new ParamCheckRuntimeException("not found");
        }
        operation.setApis(param.getApiIds());
        operationService.updateOperation(operation);
        return SimpleResponse.accepted();
    }

    @Data
    @Builder
    public static class AddActionParam{
        @NotNull
        private Integer menuId;

        @NotBlank
        private String name;

        private String remark;
    }

    @Data
    @Builder
    @ToString
    public static class EditOperationApiParam {

        @NotNull
        private Integer operationId;

        @NotEmpty
        @NotNull
        private List<Integer> apiIds;

    }

}
