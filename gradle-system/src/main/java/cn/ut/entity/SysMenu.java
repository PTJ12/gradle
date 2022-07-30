package cn.ut.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value="SysMenu对象", description="菜单表")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "路由url")
    private String url;

    @ApiModelProperty(value = "路由path")
    private String path;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "是否保持激活")
    @TableField("keep_activity")
    private Integer keepActivity;

    @ApiModelProperty(value = "是否需要权限")
    @TableField("requre_auth")
    private Integer requreAuth;

    @ApiModelProperty(value = "父组件id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "是否启用")
    private Integer enabled;


}
