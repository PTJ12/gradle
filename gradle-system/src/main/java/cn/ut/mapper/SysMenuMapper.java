package cn.ut.mapper;


import cn.ut.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id获取菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenuByAdminId(Long id);
}
