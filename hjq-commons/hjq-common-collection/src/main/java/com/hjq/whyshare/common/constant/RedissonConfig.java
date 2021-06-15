package com.hjq.whyshare.common.constant;

import com.hjq.whyshare.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */
@Configuration
@Slf4j
@ConditionalOnProperty(value = "redis.whyshare.enable", havingValue = "true")
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(Config config) {
        return Redisson.create(config);
    }

    @Bean
    public Config init() throws IOException {
        File file = new File(RedissonConfig.class.getResource("/").getPath() + "redissonConfig.yml");

        try {
            return Config.fromYAML(file);
        } catch (IOException e) {
            log.error("配置错误", e);
            throw e;
        }
    }
}
