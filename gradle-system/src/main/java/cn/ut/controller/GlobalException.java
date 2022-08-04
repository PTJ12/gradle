package cn.ut.controller;

import cn.ut.util.RestBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author PuTongjiao
 * @date 2022/8/3 20:15
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RestBean mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RestBean.error("该数据有关联数据，操作失败");
        }
        return RestBean.error("数据库异常，操作失败");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public RestBean usernameException(UsernameNotFoundException e){
        return RestBean.error("用户名或密码不正确");
    }
}
