package com.hjq.whyshare.ask.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author hjq
 * @Date 2021/6/8
 */
@RefreshScope
@ConfigurationProperties(prefix = "nacos")
@Component
@Data
public class NacosPropertiesTest {

    private String name;
}
