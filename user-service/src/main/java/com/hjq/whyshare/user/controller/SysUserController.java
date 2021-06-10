package com.hjq.whyshare.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.hjq.whyshare.user.pojo.dto.SysUser;
import com.hjq.whyshare.user.service.ISysUserService;
import com.hjq.whyshare.common.pojo.dto.PageResult;
import com.hjq.whyshare.common.pojo.dto.Result;

/**
 * 
 *
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
@Slf4j
@RestController
@RequestMapping("/sysuser")
@Api(tags = "")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping
    public PageResult list(@RequestParam Map<String, Object> params) {
        return sysUserService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public Result findUserById(@PathVariable Long id) {
        SysUser model = sysUserService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public Result save(@RequestBody SysUser sysUser) {
        sysUserService.saveOrUpdate(sysUser);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        sysUserService.removeById(id);
        return Result.succeed("删除成功");
    }
}
