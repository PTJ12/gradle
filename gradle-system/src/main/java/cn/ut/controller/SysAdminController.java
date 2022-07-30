package cn.ut.controller;

import cn.ut.entity.SysAdmin;
import cn.ut.service.ISysAdminService;
import cn.ut.util.JwtTokenUtil;
import cn.ut.util.RestBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PuTongjiao
 * @date 2022/7/25 23:06
 */
@RestController
public class SysAdminController {

    @Autowired
    private ISysAdminService sysAdminService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("getAdminAll")
    public List<SysAdmin> getSysAdminAll() {
        List<SysAdmin> list = sysAdminService.list();

        return list;
    }

    @PostMapping("getAdminAll")
    @ApiOperation("添加用户")
    public RestBean insertSysAdmin(@RequestBody SysAdmin sysAdmin) {
        sysAdmin.setPassword(new BCryptPasswordEncoder().encode(sysAdmin.getPassword()));
        boolean save = sysAdminService.save(sysAdmin);
        if (save){
            return RestBean.success("添加成功");
        }
        return RestBean.error("添加失败");
    }
}
