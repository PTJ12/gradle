package cn.ut.controller;

import cn.ut.entity.SysAdmin;
import cn.ut.entity.SysAdminRole;
import cn.ut.service.ISysAdminRoleService;
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
    private ISysAdminRoleService sysAdminRoleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/insert")
    @ApiOperation("添加用户")
    public RestBean insertSysAdmin(@RequestBody SysAdmin sysAdmin) {
        sysAdmin.setPassword(new BCryptPasswordEncoder().encode(sysAdmin.getPassword()));
        sysAdmin.setNickname("用户" + ((int) (Math.random()*9+1)*1000));
        sysAdmin.setEnable(true);
        boolean save = sysAdminService.save(sysAdmin);
        if (save){
            SysAdmin adminByUsername = sysAdminService.getAdminByUsername(sysAdmin.getUsername());
            Long id = adminByUsername.getId();
            SysAdminRole sysAdminRole = new SysAdminRole();
            sysAdminRole.setAId(id);
            sysAdminRole.setRId(3L);
            boolean adminRole = sysAdminRoleService.save(sysAdminRole);
            if (!adminRole){
                return RestBean.error("添加失败");
            }
            return RestBean.success("添加成功");

        }
        return RestBean.error("添加失败");
    }
}
