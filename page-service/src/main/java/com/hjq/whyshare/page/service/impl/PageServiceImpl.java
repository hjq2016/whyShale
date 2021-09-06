package com.hjq.whyshare.page.service.impl;

import com.hjq.whyshare.commons.util.LoginUserUtil;
import com.hjq.whyshare.page.pojo.dto.PageAgree;
import com.hjq.whyshare.page.pojo.query.PageQuery;
import com.hjq.whyshare.page.service.IPageAgreeService;
import com.hjq.whyshare.page.service.IPageBasicService;
import com.hjq.whyshare.page.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author hjq
 * @Date 2021/7/27
 */
@Service
public class PageServiceImpl implements IPageService {

    @Autowired
    private IPageBasicService pageBasicService;
    @Autowired
    private IPageAgreeService pageAgreeService;
    @Override
    public void setPageAgree(PageQuery.SetPageAgreeQuery query) {

        pageBasicService.pageAgreeHandle(query.getPageId(), query.getIncrement());
        PageAgree pageAgree = new PageAgree();
        pageAgree.setPageId(query.getPageId());
        pageAgree.setUid(LoginUserUtil.getUserId());
        pageAgree.setAgreeStatus(String.valueOf(query.getOperator()));
        pageAgreeService.updateAgreeStatus(pageAgree);
    }
}
