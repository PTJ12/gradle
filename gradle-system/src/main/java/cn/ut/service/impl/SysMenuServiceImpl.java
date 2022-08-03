package cn.ut.service.impl;


import cn.ut.entity.SysAdmin;
import cn.ut.entity.SysMenu;
import cn.ut.mapper.SysAdminMapper;
import cn.ut.mapper.SysMenuMapper;
import cn.ut.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
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

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 根据用户id获取菜单列表
     * @return
     */
    @Override
    public List<SysMenu> getMenusByAdminId() {
        Long id = ((SysAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //从redis获取菜单数据
        List<SysMenu> menus = (List<SysMenu>) valueOperations.get("menu_" + id);
        //如果为空 从数据库中获取
        if (CollectionUtils.isEmpty(menus)){
            menus = sysMenuMapper.getMenusByAdminId(id);
            //将数据设置到redis中
            valueOperations.set("menu" + id, menus);
        }
        return menus;
    }

    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<SysMenu> getMenusWithRole() {
        return sysMenuMapper.getMenusWithRole();
    }
}
