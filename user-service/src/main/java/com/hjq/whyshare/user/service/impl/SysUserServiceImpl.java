package com.hjq.whyshare.user.service.impl;

import org.springframework.stereotype.Service;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.hjq.whyshare.user.pojo.dto.SysUser;
import com.hjq.whyshare.user.mapper.SysUserMapper;
import com.hjq.whyshare.user.service.ISysUserService;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
@Slf4j
@Service
public class SysUserServiceImpl extends SuperServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<SysUser> findList(Map<String, Object> params){
        Page<SysUser> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<SysUser> list  =  baseMapper.findList(page, params);
        return PageResult.<SysUser>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
