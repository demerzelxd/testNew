package cn.me.myboot.mapper;

import cn.me.myboot.model.dto.UserGradeDetailDTO;
import cn.me.myboot.model.po.GradePO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

/**
 * 成绩表 Mapper 接口
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
public interface GradeMapper extends BaseMapper<GradePO> {

    /**
     * 分页查询用户得分信息
     *
     * @param page 分页参数
     * @param queryWrapper 查询条件
     * @return 用户得分信息
     */
    IPage<UserGradeDetailDTO> listUserGradeDetail(IPage<UserGradeDetailDTO> page, @Param(Constants.WRAPPER) QueryWrapper<UserGradeDetailDTO> queryWrapper);
}
