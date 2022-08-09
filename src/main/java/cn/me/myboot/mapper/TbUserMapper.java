package cn.me.myboot.mapper;

import cn.me.myboot.model.dto.UserDetailDTO;
import cn.me.myboot.model.po.TbUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 *
 * @author 李心达
 * @since 2022-08-09 09:36:59
 */
public interface TbUserMapper extends BaseMapper<TbUser> {
    IPage<UserDetailDTO> listUserDetail(IPage<UserDetailDTO> page, @Param(Constants.WRAPPER) QueryWrapper<UserDetailDTO> queryWrapper);
}




