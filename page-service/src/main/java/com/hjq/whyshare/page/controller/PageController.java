package com.hjq.whyshare.page.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.commons.pojo.dto.Result;
import com.hjq.whyshare.commons.pojo.dto.SysUser;
import com.hjq.whyshare.commons.util.LoginUserUtil;
import com.hjq.whyshare.page.pojo.dto.PageBasic;
import com.hjq.whyshare.page.pojo.query.PageQuery;
import com.hjq.whyshare.page.service.IPageAgreeService;
import com.hjq.whyshare.page.service.IPageBasicService;
import com.hjq.whyshare.page.service.IPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author hjq
 * @Date 2021/7/8
 */

@RestController
@RequestMapping("/page")
@Slf4j
public class PageController {
    @Autowired
    private IPageBasicService pageBasicService;
    @Autowired
    private IPageAgreeService pageAgreeService;
    @Autowired
    private IPageService pageService;

    @PostMapping
    public Result createPage(@RequestBody PageQuery.CreatePageQuery query) {
        log.info("{}", query);
        PageBasic pageBasic = new PageBasic();
        BeanUtils.copyProperties(query, pageBasic);
        SysUser sysUser = LoginUserUtil.getUser();
        pageBasic.setAuthorId(sysUser.getId());
        log.info("{}", pageBasic);
        pageBasicService.save(pageBasic);
        return Result.succeed();
    }
    @GetMapping
    public Result getPages(PageQuery.GetPagesQuery query) {
        log.info("{}", query);
        IPage<PageBasic> page = new Page<>();
        page.setCurrent(query.getPageNo());
        page.setSize(query.getPageSize());
        SysUser sysUser = LoginUserUtil.getUser();
        IPage<PageBasic> kk = pageBasicService.page(page, Wrappers.lambdaQuery(PageBasic.class).eq(PageBasic::getAuthorId, sysUser.getId()));
        return Result.succeed(kk);
    }

    @GetMapping("/all")
    public Result getAllPages(PageQuery.GetPagesQuery query) {
        log.info("{}", query);
        IPage<PageBasic> page = new Page<>();
        page.setCurrent(query.getPageNo());
        page.setSize(query.getPageSize());
        IPage<PageBasic> kk = pageBasicService.page(page);
        return Result.succeed(kk);
    }
    @PostMapping("/pageAgree")
    public Result setPageAgree(@RequestBody PageQuery.SetPageAgreeQuery query) {
        log.info("PageQuery.SetPageAgreeQuery{}", query);
        pageService.setPageAgree(query);
        return Result.succeed();
    }


}
