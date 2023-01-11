package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author anthony
 * @date 2023/1/11
 */
@Slf4j
@RestController
@RequestMapping("lock")
public class RedissonLockController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("getLock")
    public String getLock(){
        RLock lock = redissonClient.getLock(this.getClass().getName());
        try {
            if (lock.tryLock(10L, 10L, TimeUnit.SECONDS)){
                Thread.sleep(9000L);
                return "锁已经执行完业务逻辑";
            }else {
                log.info("等待锁失败");
                return "等待锁失败";
            }
        }catch (Exception e){
            log.info("获取锁失败，异常信息{}", e.getMessage(), e);
            return "Failure";
        }finally {
            // 释放锁
            if (lock.isLocked() && lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
