package com.hjq.whyshare.user.controller;

import com.hjq.whyshare.common.constant.Constants;
import com.hjq.whyshare.common.enums.AliErrorCodeEnum;
import com.hjq.whyshare.common.exception.BusinessException;
import com.hjq.whyshare.common.pojo.dto.Result;
import com.hjq.whyshare.user.pojo.query.LoginQuery;
import com.hjq.whyshare.user.pojo.vo.LoginVo;
import com.hjq.whyshare.user.service.ILoginService;
import com.hjq.whyshare.user.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */

@Slf4j
@RestController
@RequestMapping("/login")
@Api(tags = "")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping
    public Result login(HttpServletResponse response, @RequestBody LoginQuery.LoginMethodQuery query) {
        if (StringUtils.isBlank(query.getUsername()) || StringUtils.isBlank(query.getPassword())) {
            throw new BusinessException(AliErrorCodeEnum.USER_ERROR_A0200);
        }
        LoginVo.LoginMethodVo vo = loginService.login(query);
        response.addHeader(Constants.ACCESS_TOKEN, vo.getAccessToken());
        return Result.succeed();
    }
}
