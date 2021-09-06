package com.hjq.whyshare.commons.util;

import com.hjq.whyshare.commons.constant.Constants;
import com.hjq.whyshare.commons.pojo.dto.SysUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hjq
 * @description
 * @date 2021/6/17
 */
public class LoginUserUtil {

    public static SysUser getUser() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return (SysUser)request.getAttribute(Constants.REQUEST_USER_ATTRIBUTE);
    }

    public static Long getUserId() {
        return getUser().getId();
    }

}
