package com.hjq.whyshare.ask.controller;

import com.hjq.whyshare.common.pojo.dto.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjq
 * @description
 * @date 2021/6/11
 */
@RestController
@Slf4j
@RequestMapping("/members/{id}/questions")
public class QuestionController {

    @ApiOperation(value = "创建提问")
    @PostMapping
    public Result createQuestion(@PathVariable String id) {
        return Result.succeed("成功");
    }
}
