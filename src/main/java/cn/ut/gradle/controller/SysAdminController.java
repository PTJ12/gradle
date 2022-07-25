package cn.ut.gradle.controller;

import cn.ut.gradle.entity.SysAdmin;
import cn.ut.gradle.service.SysAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PuTongjiao
 * @date 2022/7/25 23:06
 */
@RestController
public class SysAdminController {

    @Autowired
    private SysAdminService sysAdminService;

    @GetMapping("getAdminAll")
    public List<SysAdmin> getSysAdminAll() {
        List<SysAdmin> list = sysAdminService.list();
        return list;
    }
}
