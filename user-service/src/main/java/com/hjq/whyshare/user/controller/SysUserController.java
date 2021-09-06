package com.hjq.whyshare.user.controller;

import com.hjq.whyshare.commons.pojo.dto.PageResult;
import com.hjq.whyshare.commons.pojo.dto.Result;
import com.hjq.whyshare.commons.util.RedissonUtil;
import com.hjq.whyshare.commons.pojo.dto.SysUser;
import com.hjq.whyshare.user.pojo.query.SysUserQuery;
import com.hjq.whyshare.user.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hjq
 * @date 2021-06-10 18:24:05
 */
@Slf4j
@RestController
@RequestMapping("/users")
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
    @ApiOperation(value = "注册用户")
    @PostMapping("/register")
    public Result register(@RequestBody SysUserQuery.RegisterQuery query) {
        sysUserService.register(query);
        return Result.succeed("保存成功");
    }

    @ApiOperation(value = "更新密码")
    @PostMapping("/password")
    public Result updatePassword(@RequestBody SysUserQuery.UpdatePasswordQuery query) {
        boolean f = sysUserService.updatePassword("username", query.getUsername(), query.getOldPassword(), query.getPassword());
        if (f) {
            return Result.succeed("更新密码成功");
        } else {
            return Result.failed("更新密码失败");
        }

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

    @GetMapping(value = "accessToken")
    public Result getUserByToken(String accessToken) {
        log.info("getUserByToken, accessToken = " + accessToken);
        String user = RedissonUtil.get(accessToken);
        if (null == user) {
            return Result.failed("获取user缓存失败");
        }
        return Result.succeedData(user);
    }

}
