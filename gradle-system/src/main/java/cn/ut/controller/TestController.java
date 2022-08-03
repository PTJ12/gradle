package cn.ut.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PuTongjiao
 * @date 2022/8/3 18:41
 */
@RestController
@Api(tags = "测试")
public class TestController {

    @GetMapping("/system/menu/test")
    public String test1(){
        return "/system/menu/test";
    }

    @GetMapping("/system/user/test")
    public String test2(){
        return "/system/user/test";
    }
    @GetMapping("/system/cfg/test")
    public String test3(){
        return "/system/cfg/test";
    }
}
