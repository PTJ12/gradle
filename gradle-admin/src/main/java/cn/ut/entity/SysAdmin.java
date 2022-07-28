package cn.ut.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author PuTongjiao
 * @date 2022/7/25 22:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_admin")
public class SysAdmin {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String username;
    private String password;
    private int enable;

    @TableField(fill = FieldFill.INSERT)
    private Date create_time;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;
}
