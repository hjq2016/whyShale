package com.hjq.whyshare.user.service.impl;

import com.hjq.whyshare.commons.enums.AliErrorCodeEnum;
import com.hjq.whyshare.commons.exception.BusinessException;
import com.hjq.whyshare.commons.util.JacksonUtils;
import com.hjq.whyshare.commons.util.RedissonUtil;
import com.hjq.whyshare.commons.pojo.dto.SysUser;
import com.hjq.whyshare.user.pojo.query.LoginQuery;
import com.hjq.whyshare.user.pojo.vo.LoginVo;
import com.hjq.whyshare.user.service.ILoginService;
import com.hjq.whyshare.user.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ISysUserService sysUserService;

    private static final long LOGIN_TIME = 60 * 60 * 24 * 3;

    @Override
    public LoginVo.LoginMethodVo login(LoginQuery.LoginMethodQuery query) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(query.getUsername());
        sysUser.setPassword(query.getPassword());
        SysUser findUser = sysUserService.find(sysUser);

        if (findUser == null) {
            sysUser = new SysUser();
            sysUser.setUsername(query.getUsername());
            findUser = sysUserService.find(sysUser);
            if (findUser == null) {
                throw new BusinessException(AliErrorCodeEnum.USER_ERROR_A0201);
            } else {
                throw new BusinessException(AliErrorCodeEnum.USER_ERROR_A0210);
            }
        }
        //设置redis access_token
        String accessToken = UUID.randomUUID().toString();
        RedissonUtil.set(accessToken, JacksonUtils.toJson(findUser), LOGIN_TIME);
        LoginVo.LoginMethodVo vo = new LoginVo.LoginMethodVo();
        vo.setAccessToken(accessToken);
        return vo;
    }
}
