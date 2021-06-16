package com.hjq.whyshare.common.annotation;

import com.hjq.whyshare.common.util.RedissonUtil;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hjq
 * @description
 * @date 2021/6/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({RedissonUtil.class})
public @interface EnableRedissonUse {

}