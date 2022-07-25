package cn.ut.gradle.controller;

import cn.ut.gradle.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author PuTongjiao
 * @date 2022/7/25 22:37
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test();
    }
}
