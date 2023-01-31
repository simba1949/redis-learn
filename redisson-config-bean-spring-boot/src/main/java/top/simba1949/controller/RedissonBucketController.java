package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthony
 * @date 2023/1/31
 */
@Slf4j
@RestController
@RequestMapping("bucket")
public class RedissonBucketController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("setKey")
    public String setKey(String key, String value){
        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(value);
        return "SUCCESS";
    }

    @GetMapping("getKey")
    public String getKey(String key){
        RBucket<String> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }
}
