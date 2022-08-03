package cn.ut.mapper;


import cn.ut.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id获取菜单列表
     * @param id
     * @return
     */
    List<SysMenu> getMenusByAdminId(Long id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<SysMenu> getMenusWithRole();
}
