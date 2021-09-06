package com.hjq.whyshare.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * service接口父类
 *
 * @author zlt
 * @date 2019/1/10
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 *
 * 做了修改，先不做分布式锁
 */
public interface ISuperService<T> extends IService<T> {
}
