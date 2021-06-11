package com.hjq.whyshare.ask.service.impl;

import org.springframework.stereotype.Service;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.hjq.whyshare.ask.pojo.dto.QuestionBasic;
import com.hjq.whyshare.ask.mapper.QuestionBasicMapper;
import com.hjq.whyshare.ask.service.IQuestionBasicService;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-11 17:51:29
 */
@Slf4j
@Service
public class QuestionBasicServiceImpl extends SuperServiceImpl<QuestionBasicMapper, QuestionBasic> implements IQuestionBasicService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<QuestionBasic> findList(Map<String, Object> params){
        Page<QuestionBasic> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<QuestionBasic> list  =  baseMapper.findList(page, params);
        return PageResult.<QuestionBasic>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
