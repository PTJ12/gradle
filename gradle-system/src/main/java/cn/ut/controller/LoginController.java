package cn.ut.controller;

import cn.ut.entity.AdminLoginParam;
import cn.ut.entity.SysAdmin;
import cn.ut.service.ISysAdminService;
import cn.ut.util.RestBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author PuTongjiao
 * @date 2022/7/30 13:15
 */
@Api(tags = "登录接口")
@RestController
public class LoginController {

    @Autowired
    private ISysAdminService sysAdminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RestBean login(@RequestBody AdminLoginParam loginParam, HttpServletRequest request){
        return sysAdminService.login(loginParam.getUsername(), loginParam.getPassword(), request);
    }

    @ApiOperation("获取当前登录用户信息")
    @GetMapping("/admin/info")
    public RestBean getAdminInfo(Principal principal) {
        if (null == principal){
            return RestBean.error("重新登录");
        }
        String username = principal.getName();
        SysAdmin sysAdmin = sysAdminService.getAdminByUsername(username);
        sysAdmin.setPassword(null);
        return RestBean.success("操作成功", sysAdmin);
    }
}
