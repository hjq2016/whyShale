package com.hjq.whyshare.page.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjq.whyshare.common.pojo.dto.Result;
import com.hjq.whyshare.common.pojo.dto.SysUser;
import com.hjq.whyshare.common.util.LoginUserUtil;
import com.hjq.whyshare.page.pojo.dto.PageBasic;
import com.hjq.whyshare.page.pojo.query.PageQuery;
import com.hjq.whyshare.page.service.IPageBasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

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
        IPage<PageBasic> kk = pageBasicService.page(page);
        return Result.succeed(kk);
    }
}
