package cn.ut.controller;

import cn.ut.util.RestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PuTongjiao
 * @date 2022/7/30 18:21
 */
@RestController
public class LogoutController {

    @GetMapping("/out")
    public RestBean logout(){
        return RestBean.success("退出成功");
    }
}
