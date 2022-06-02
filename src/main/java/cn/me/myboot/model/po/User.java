package cn.me.myboot.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Giskard
 * @since 2022-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


}
