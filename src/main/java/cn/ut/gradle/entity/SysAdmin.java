package cn.ut.gradle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PuTongjiao
 * @date 2022/7/25 22:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_admin")
public class SysAdmin {

    @TableId(type = IdType.ASSIGN_UUID)
    private Long id;

    private String username;
    private String password;
    private int enable;
}
