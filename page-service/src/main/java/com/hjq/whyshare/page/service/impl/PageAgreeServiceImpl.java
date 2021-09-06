package com.hjq.whyshare.page.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import com.hjq.whyshare.commons.pojo.dto.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.commons.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.hjq.whyshare.page.pojo.dto.PageAgree;
import com.hjq.whyshare.page.mapper.PageAgreeMapper;
import com.hjq.whyshare.page.service.IPageAgreeService;

/**
 * @author hjq
 * @date 2021-07-27 11:42:45
 */
@Slf4j
@Service
public class PageAgreeServiceImpl extends SuperServiceImpl<PageAgreeMapper, PageAgree> implements IPageAgreeService {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult<PageAgree> findList(Map<String, Object> params) {
        Page<PageAgree> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<PageAgree> list = baseMapper.findList(page, params);
        return PageResult.<PageAgree>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public boolean updateAgreeStatus(PageAgree pageAgree) {
        return this.saveOrUpdate(pageAgree, Wrappers.lambdaUpdate(PageAgree.class)
                .eq(PageAgree::getPageId, pageAgree.getPageId())
                .eq(PageAgree::getUid, pageAgree.getUid()));
    }
}
