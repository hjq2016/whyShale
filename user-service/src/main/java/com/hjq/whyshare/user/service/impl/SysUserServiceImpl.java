package com.hjq.whyshare.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.common.enums.AliErrorCodeEnum;
import com.hjq.whyshare.common.exception.BusinessException;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.hjq.whyshare.common.service.impl.SuperServiceImpl;
import com.hjq.whyshare.user.mapper.SysUserMapper;
import com.hjq.whyshare.user.pojo.dto.SysUser;
import com.hjq.whyshare.user.pojo.query.SysUserQuery;
import com.hjq.whyshare.user.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
@Slf4j
@Service
public class SysUserServiceImpl extends SuperServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult<SysUser> findList(Map<String, Object> params) {
        Page<SysUser> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<SysUser> list = baseMapper.findList(page, params);
        return PageResult.<SysUser>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public void register(SysUserQuery.RegisterQuery query) {
        if (findByName(query.getUsername()) != null) {
            throw new BusinessException(AliErrorCodeEnum.USER_ERROR_A0111);
        }
        SysUser sysUser = new SysUser();
        sysUser.setUsername(query.getUsername());
        sysUser.setPassword(query.getPassword());
        this.save(sysUser);
    }

    @Override
    public SysUser findByName(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        return getOne(queryWrapper);
    }

    @Override
    public SysUser find(SysUser sysUser) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (sysUser.getUsername() != null) {
            queryWrapper.eq("username", sysUser.getUsername());
        }
        if (sysUser.getPassword() != null) {
            queryWrapper.eq("password", sysUser.getPassword());
        }
        return getOne(queryWrapper);
    }

    @Override
    public boolean updatePassword(String condition, String value, String oldPassword, String password) {
        QueryWrapper queryWrapper = Wrappers.query().eq(condition, value).eq("password", oldPassword);
        SysUser sysUser = getOne(queryWrapper);
        if (null == sysUser) {
            log.error("find fail");
            return false;
        }

        UpdateWrapper<SysUser> wrapper = Wrappers.update();
        wrapper.eq(condition, value).eq("password", oldPassword);
        wrapper.set("password", password);
        return update(wrapper);

    }


}
