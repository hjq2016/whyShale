package com.hjq.whyshare.commons.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author hjq
 * @description
 * @date 2021/6/15
 */
@Slf4j
public class RedissonUtil {

    private static final long DEFAULT_EXPIRE = 30;

    private static RedissonClient redissonClient;

    @Autowired
    private RedissonUtil(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 设置key-value expire时间
     *
     * @param key
     * @param value
     * @param time
     * @param <T>
     */
    public static <T> void set(String key, T value, long time) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        bucket.set(value, time, TimeUnit.SECONDS);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public static void del(String key) {
        RBucket bucket = redissonClient.getBucket(key);
        bucket.delete();
    }

    /**
     * 获取缓存
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    /**
     * 获取字节流
     *
     * @param key
     * @param
     * @return
     */
    public static byte[] getBinary(String key) {
        RBinaryStream binaryStream = redissonClient.getBinaryStream(key);
        return binaryStream.get();
    }

    /**
     * 设置key-value expire时间
     *
     * @param key
     * @param value
     * @param <T>
     */
    public static <T> void set(String key, T value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 设置字节流
     *
     * @param key
     * @param
     * @return
     */
    public static void setBinary(String key, byte[] value, long timeToLive) {
        RBinaryStream binaryStream = redissonClient.getBinaryStream(key);
        binaryStream.set(value, timeToLive, TimeUnit.SECONDS);
    }

    /**
     * 是否存在
     *
     * @param key
     * @return
     */
    public static boolean isExist(String key) {
        RBucket bucket = redissonClient.getBucket(key);
        return bucket.isExists();
    }

    /**
     * 获取分布式锁 阻塞接口
     *
     * @param lockName
     * @param leaseTime
     * @return
     */
    public static void lock(String lockName, long leaseTime) {
        RLock rlock = redissonClient.getLock(lockName);
        rlock.lock(leaseTime, TimeUnit.SECONDS);
    }

    /**
     * 尝试获取锁 (无等待时间)
     *
     * @param lockName
     * @param leaseTime
     * @return
     */
    public static boolean tryLock(String lockName, long leaseTime) {
        RLock rlock = redissonClient.getLock(lockName);
        try {
            return rlock.tryLock(leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("获取分布式锁异常" + lockName, e);
            return false;
        }
    }

    /**
     * 尝试获取锁 (有等待时间)
     *
     * @param lockName
     * @param leaseTime
     * @param waitTime
     * @return
     */
    public static boolean tryLock(String lockName, long leaseTime, long waitTime) {
        RLock rlock = redissonClient.getLock(lockName);
        try {
            return rlock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("获取分布式锁异常" + lockName, e);
            return false;
        }
    }

    /**
     * 释放锁
     *
     * @param lockName
     * @return
     */
    public static void unLock(String lockName) {
        RLock rlock = redissonClient.getLock(lockName);
        rlock.unlock();
    }

    /**
     * 判断该线程是否持有当前锁
     *
     * @param lockName 锁名称
     */
    public boolean isHeldByCurrentThread(String lockName) {
        RLock rLock = redissonClient.getLock(lockName);
        return rLock.isHeldByCurrentThread();
    }

    /**
     * 获取递增值
     *
     * @param key
     * @return
     */
    public static long incre(String key) {
        RAtomicLong rAtomicLong = redissonClient.getAtomicLong(key);
        return rAtomicLong.incrementAndGet();
    }

}
