package cn.ut.config.filter;

import cn.ut.entity.SysMenu;
import cn.ut.entity.SysRole;
import cn.ut.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url分析请求所需要的角色
 * @author PuTongjiao
 * @date 2022/7/11 22:23
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private ISysMenuService sysMenuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<SysMenu> menus = sysMenuService.getMenusWithRole();
        for (SysMenu menu : menus) {
            //TODO 判断请求url与菜单角色是否匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
//                System.out.println(menu);
                String[] str = menu.getRoles().stream().map(SysRole::getName).toArray(String[]::new);
                return SecurityConfig.createList(str);
            }
        }
        //没匹配的url默认登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
