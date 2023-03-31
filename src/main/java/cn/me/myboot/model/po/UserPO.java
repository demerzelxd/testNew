package cn.me.myboot.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 用户表
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_user")
@ApiModel(value = "UserPO对象", description = "用户表")
public class UserPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId("id")
    private String id;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("性别")
    @TableField("user_gender")
    private String userGender;

    @ApiModelProperty("地址")
    @TableField("user_addr")
    private String userAddr;

    @ApiModelProperty("年龄")
    @TableField("user_age")
    private String userAge;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("更新用户")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty("删除标志")
    @TableField("del_flag")
    private String delFlag;
}
