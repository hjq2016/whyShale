package com.hjq.whyshare.commons.interceptor;


import com.hjq.whyshare.commons.constant.Constants;
import com.hjq.whyshare.commons.enums.AliErrorCodeEnum;
import com.hjq.whyshare.commons.exception.BusinessException;
import com.hjq.whyshare.commons.feign.UserServiceFeign;
import com.hjq.whyshare.commons.pojo.dto.Result;
import com.hjq.whyshare.commons.pojo.dto.SysUser;
import com.hjq.whyshare.commons.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hjq
 * @description
 * @date 2021/6/16
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    UserServiceFeign userServiceFeign;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("TokenInterceptor preHandle");
        String accessToken = request.getHeader(Constants.ACCESS_TOKEN);
        if (StringUtils.isBlank(accessToken)) {
            return true;
        }
        Result<String> result = userServiceFeign.getUserByToken(accessToken);
        log.info(JacksonUtils.toJson(result));
        if (0 != result.getResp_code()) {
            throw new BusinessException(AliErrorCodeEnum.USER_ERROR_A0300);
        }
        SysUser sysUser = JacksonUtils.toObj(result.getData(), SysUser.class);
        request.setAttribute(Constants.REQUEST_USER_ATTRIBUTE, sysUser);
        return true;
    }
}
