package com.hjq.whyshare.ask.service;

import com.hjq.whyshare.ask.pojo.dto.QuestionBasic;
import com.hjq.whyshare.commons.pojo.dto.PageResult;
import com.hjq.whyshare.commons.service.ISuperService;

import java.util.Map;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-11 17:51:29
 */
public interface IQuestionBasicService extends ISuperService<QuestionBasic> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<QuestionBasic> findList(Map<String, Object> params);
}

