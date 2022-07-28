package cn.ut.controller;

import cn.ut.entity.SysAdmin;
import cn.ut.service.SysAdminService;
import cn.ut.util.JwtTokenUtil;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("getAdminAll")
    public List<SysAdmin> getSysAdminAll() {
        List<SysAdmin> list = sysAdminService.list();

        return list;
    }
}
