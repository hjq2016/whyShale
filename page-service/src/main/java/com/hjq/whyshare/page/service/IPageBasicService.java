package com.hjq.whyshare.page.service;

import com.hjq.whyshare.page.pojo.dto.PageBasic;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.hjq.whyshare.common.service.ISuperService;

import java.util.Map;

/**
 * 
 *
 * @author hjq
 * @date 2021-07-07 14:22:38
 */
public interface IPageBasicService extends ISuperService<PageBasic> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<PageBasic> findList(Map<String, Object> params);
}

