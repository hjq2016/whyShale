package com.hjq.whyshare.page.service;

import com.hjq.whyshare.page.pojo.dto.PageAgree;
import com.hjq.whyshare.commons.pojo.dto.PageResult;
import com.hjq.whyshare.commons.service.ISuperService;

import java.util.Map;

/**
 * 
 *
 * @author hjq
 * @date 2021-07-27 11:42:45
 */
public interface IPageAgreeService extends ISuperService<PageAgree> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<PageAgree> findList(Map<String, Object> params);

    boolean updateAgreeStatus(PageAgree pageAgree);
}

