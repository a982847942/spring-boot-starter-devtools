package edu.nuaa.middleware.test.service;

import edu.nuaa.middleware.redis.annotation.XRedis;

/**
 * @author brain
 * @version 1.0
 * @date 2023/6/23 13:46
 */
@XRedis
public interface IRedisService {
    String get(String key);
    void set(String key,String val);
}
