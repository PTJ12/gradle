package cn.ut.service.impl;


import cn.ut.entity.SysAdmin;
import cn.ut.entity.SysMenu;
import cn.ut.mapper.SysAdminMapper;
import cn.ut.mapper.SysMenuMapper;
import cn.ut.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据用户id获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        SysAdmin sysAdmin = (SysAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sysMenuMapper.getMenuByAdminId(sysAdmin.getId());
    }
}
