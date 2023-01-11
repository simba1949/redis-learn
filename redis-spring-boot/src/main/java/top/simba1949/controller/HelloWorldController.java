package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthony
 * @date 2023/1/11
 */
@Slf4j
@RestController
@RequestMapping()
public class HelloWorldController {

    @GetMapping("sayHello")
    public String sayHello(){
        return "Hello World!";
    }
}
