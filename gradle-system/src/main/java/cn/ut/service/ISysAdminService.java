package cn.ut.service;

import cn.ut.entity.SysAdmin;
import cn.ut.util.RestBean;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author PuTongjiao
 * @date 2022/7/25 23:03
 */
public interface ISysAdminService extends IService<SysAdmin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RestBean login(String username, String password, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    SysAdmin getAdminByUsername(String username);
}
