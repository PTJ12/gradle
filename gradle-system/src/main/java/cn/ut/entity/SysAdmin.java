package cn.ut.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_admin")
@ApiModel(value="SysAdmin对象", description="用户表")
public class SysAdmin implements Serializable , UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "电话号码")
    private Long phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private List<SysRole> roles;

    @ApiModelProperty(value = "激活状态 默认1")
    private Boolean enable;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = roles
                .stream().
                map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
