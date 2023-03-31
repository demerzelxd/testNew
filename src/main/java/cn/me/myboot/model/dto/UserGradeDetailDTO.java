package cn.me.myboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户得分详情DTO
 *
 * @author 李心达
 * @since 2023-03-31 14:13:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserGradeDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 科目ID
     */
    private String subjectId;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 分数
     */
    private String scoreNum;
}
