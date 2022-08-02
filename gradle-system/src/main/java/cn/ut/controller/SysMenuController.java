package cn.ut.controller;


import cn.ut.service.ISysMenuService;
import cn.ut.util.RestBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
@RestController
@RequestMapping("/system")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;
    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public RestBean getMenusByAdminId(){
        List<Menu> menus = sysMenuService.getMenusByAdminId();
        return RestBean.success("操作成功", menus);
    }
}
