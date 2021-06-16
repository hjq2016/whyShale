package com.hjq.whyshare.common.interceptor;


import com.hjq.whyshare.common.constant.Constants;
import com.hjq.whyshare.common.feign.UserServiceFeign;
import com.hjq.whyshare.common.pojo.dto.Result;
import com.hjq.whyshare.common.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.Filter;
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
            accessToken = request.getParameter(Constants.ACCESS_TOKEN);
        }
        if (StringUtils.isBlank(accessToken)) {
            return true;
        }
        Result result = userServiceFeign.getUserByToken(accessToken);
        log.info(JacksonUtils.toJson(result));

        return true;
    }
}
