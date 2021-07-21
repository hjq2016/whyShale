package com.hjq.whyshare.page.service.impl;

import org.springframework.stereotype.Service;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.hjq.whyshare.page.pojo.dto.PageBasic;
import com.hjq.whyshare.page.mapper.PageBasicMapper;
import com.hjq.whyshare.page.service.IPageBasicService;

/**
 * 
 *
 * @author hjq
 * @date 2021-07-07 14:22:38
 */
@Slf4j
@Service
public class PageBasicServiceImpl extends SuperServiceImpl<PageBasicMapper, PageBasic> implements IPageBasicService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<PageBasic> findList(Map<String, Object> params){
        Page<PageBasic> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<PageBasic> list  =  baseMapper.findList(page, params);
        return PageResult.<PageBasic>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
