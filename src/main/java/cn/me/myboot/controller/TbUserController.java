package cn.me.myboot.controller;

import cn.me.myboot.mapper.TbUserMapper;
import cn.me.myboot.model.dto.UserDetailDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 *
 * @author 李心达
 * @since 2022-08-09 08:04:18
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TbUserController.class);

    @Autowired
    private TbUserMapper userMapper;

    @PostMapping("/select")
    public String selectUserInfo() {
        // 分页参数
        IPage<UserDetailDTO> page = new Page<>(1, 10);
        // 多表queryWrapper分页查询，若为单表，直接用selectPage即可
        IPage<UserDetailDTO> pageResult = this.userMapper.listUserDetail(page, new QueryWrapper<UserDetailDTO>()
                .like("a.username", "dada").orderByAsc("a.id"));
        LOGGER.info("success...");
        return "success";
    }
}
