package com.hjq.whyshare.user.service;

import com.hjq.whyshare.common.pojo.dto.SysUser;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.hjq.whyshare.common.service.ISuperService;
import com.hjq.whyshare.user.pojo.query.SysUserQuery;

import java.util.Map;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
public interface ISysUserService extends ISuperService<SysUser> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<SysUser> findList(Map<String, Object> params);

    void register(SysUserQuery.RegisterQuery query);

    SysUser findByName(String username);

    SysUser find(SysUser sysUser);

    boolean updatePassword(String condition, String value, String oldPassword, String password);
}

