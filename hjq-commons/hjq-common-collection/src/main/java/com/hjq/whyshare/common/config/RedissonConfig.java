package com.hjq.whyshare.common.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */

@Slf4j
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
