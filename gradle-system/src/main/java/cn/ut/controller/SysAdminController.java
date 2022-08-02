package cn.ut.controller;

import cn.ut.entity.SysAdmin;
import cn.ut.service.ISysAdminService;
import cn.ut.util.JwtTokenUtil;
import cn.ut.util.RestBean;
import io.swagger.annotations.Api;
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
@Api(tags = "SysAdmin")
@RequestMapping("system/admin")
public class SysAdminController {

    @Autowired
    private ISysAdminService sysAdminService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/insert")
    @ApiOperation("添加用户")
    public RestBean insertSysAdmin(@RequestBody SysAdmin sysAdmin) {
        sysAdmin.setPassword(new BCryptPasswordEncoder().encode(sysAdmin.getPassword()));
        sysAdmin.setEnable(true);
        boolean save = sysAdminService.save(sysAdmin);
        if (save){
            return RestBean.success("添加成功");
        }
        return RestBean.error("添加失败");
    }
}
