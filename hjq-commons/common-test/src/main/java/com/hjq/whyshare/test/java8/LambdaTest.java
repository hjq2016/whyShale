package com.hjq.whyshare.test.java8;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @Description
 * @Author hjq
 * @Date 2021/8/13
 */
@Hjq
@Hjq
public class LambdaTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
    }

    private void fun(@Hjq int c) {

    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@interface Hjqs {
    Hjq[] value();
}


@Repeatable(Hjqs.class)
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.PARAMETER})
@interface Hjq {
    String value() default "123";
}

