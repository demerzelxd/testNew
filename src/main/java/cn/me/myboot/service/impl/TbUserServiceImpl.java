package cn.me.myboot.service.impl;

import cn.me.myboot.mapper.TbUserMapper;
import cn.me.myboot.model.dto.UserDetailDTO;
import cn.me.myboot.model.po.TbUser;
import cn.me.myboot.service.TbUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Impl
 *
 * @author 李心达
 * @since 2022-08-09 09:36:59
 */
@Service
@Slf4j
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
        implements TbUserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public void listUserDetail(Integer pageIndex, Integer pageSize, Boolean selectFlag) {
        if (selectFlag) {
            // 分页参数
            IPage<UserDetailDTO> page = new Page<>(pageIndex, pageSize);
            // 多表queryWrapper分页查询，若为单表，直接用selectPage即可
            IPage<UserDetailDTO> pageResult = this.userMapper.listUserDetail(page, new QueryWrapper<UserDetailDTO>()
                    .like("a.username", "dada").orderByAsc("a.id"));
            log.info("selected...");
        } else {
            log.info("not selected...");
        }
    }

}




