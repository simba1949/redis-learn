package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthony
 * @date 2023/1/11
 */
@Slf4j
@RestController
@RequestMapping("string")
public class RedisStringController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("setKey")
    public String setKey(String key, String value){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value);

        return "SUCCESS";
    }

    @GetMapping("getKey")
    public String getKey(String key){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }
}
