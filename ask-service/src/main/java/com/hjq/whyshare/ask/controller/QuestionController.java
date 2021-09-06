package com.hjq.whyshare.ask.controller;

import com.hjq.whyshare.ask.pojo.dto.QuestionBasic;
import com.hjq.whyshare.ask.pojo.query.QuestionQuery;
import com.hjq.whyshare.ask.pojo.vo.QuestionVo;
import com.hjq.whyshare.ask.service.IQuestionBasicService;
import com.hjq.whyshare.commons.enums.AliErrorCodeEnum;
import com.hjq.whyshare.commons.exception.BusinessException;
import com.hjq.whyshare.commons.pojo.dto.Result;
import com.hjq.whyshare.commons.pojo.dto.SysUser;
import com.hjq.whyshare.commons.util.LoginUserUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hjq
 * @description
 * @date 2021/6/11
 */
@RestController
@Slf4j
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    IQuestionBasicService questionBasicService;

    @ApiOperation(value = "创建提问")
    @PostMapping
    public Result createQuestion(@RequestBody QuestionQuery.CreateQuestionQuery query) {
        SysUser sysUser = LoginUserUtil.getUser();
        QuestionBasic questionBasic = new QuestionBasic();
        questionBasic.setAuthorId(sysUser.getId());
        questionBasic.setTitle(query.getTitle());
        questionBasic.setContent(query.getContent());
        questionBasicService.saveOrUpdate(questionBasic);
        return Result.succeed();
    }

    @GetMapping("/{id}")
    public Result getQuestion(@PathVariable Long id) {
        QuestionBasic questionBasic = questionBasicService.getById(id);
        if (questionBasic == null) {
            throw new BusinessException(AliErrorCodeEnum.SERVICE_ERROR_D0100);
        }
        QuestionVo.CreateQuestionVo vo = new QuestionVo.CreateQuestionVo();
        BeanUtils.copyProperties(questionBasic,vo);
        return Result.succeed(vo);
    }

}
