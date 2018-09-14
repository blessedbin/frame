package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.entity.pojo.Operation;
import com.blessedbin.frame.ucenter.service.OperationService;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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
public class OperationController {

    @Autowired
    private OperationService operationService;

    /**
     * @param param
     * @return
     */
    @PostMapping
    @FrameApi
    @ApiOperation(value = "添加功能点")
    public SimpleResponse add(@RequestBody @Validated AddActionParam param) {
        operationService.addOperation(param.getMenuId(),param.getName(),param.getRemark());
        return SimpleResponse.created();
    }


    @GetMapping
    public SimpleResponse<Object> getOperation(@RequestParam String id) {

        List<Integer> ids = Arrays.stream(id.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
        if(ids.isEmpty()) {
            throw new ParamCheckRuntimeException("参数错误");
        }
        if(ids.size() == 1){
            Operation operation = operationService.getOperation(ids.get(0));
            return SimpleResponse.ok(operation);
        } else {
            operationService.getOperations(ids);
        }
        return null;
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

}
