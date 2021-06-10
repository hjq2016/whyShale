package com.hjq.whyshare.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjq.whyshare.common.service.ISuperService;

/**
 * service实现父类
 *
 * @author zlt
 * @date 2019/1/10
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
public class SuperServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements ISuperService<T> {
}
