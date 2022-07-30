package cn.ut.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 * @author PuTongjiao
 * @date 2022/7/26 8:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestBean {
    private long code;
    private String message;
    private Object object;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RestBean success(String message) {
        return new RestBean(200, message,null);
    }

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RestBean success(String message, Object object) {
        return new RestBean(200, message,object);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RestBean error(String message){
        return new RestBean(500, message, null);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RestBean error(String message, Object object){
        return new RestBean(500, message, object);
    }
}
