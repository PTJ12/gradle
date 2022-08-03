package cn.ut.service;


import cn.ut.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据用户id获取菜单列表
     * @return
     */
    List<SysMenu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<SysMenu> getMenusWithRole();
}
