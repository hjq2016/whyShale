package com.hjq.whyshare.user.service.impl;

import com.hjq.whyshare.common.enums.AliErrorCodeEnum;
import com.hjq.whyshare.common.exception.BusinessException;
import com.hjq.whyshare.common.util.RedissonUtil;
import com.hjq.whyshare.user.pojo.dto.SysUser;
import com.hjq.whyshare.user.pojo.query.LoginQuery;
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

    @Override
    public boolean login(LoginQuery.LoginMethodQuery query) {
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
        RedissonUtil.set(accessToken, findUser, 180);
//        String value = RedissonUtil.get("hjq2021");
//        log.info(value);

        return true;
    }
}
