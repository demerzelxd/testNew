package cn.me.myboot.controller;

import cn.me.myboot.mapper.TbUserMapper;
import cn.me.myboot.model.dto.UserDetailDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 *
 * @author 李心达
 * @since 2022-08-09 08:04:18
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户Controller")
public class TbUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TbUserController.class);

    @Autowired
    private TbUserMapper userMapper;

    @PostMapping("/select")
    @ApiOperation(value = "分页查询用户信息接口",
            notes = "<span style='color:red;'>描述:</span>用来分页查询用户信息的接口")
    public String selectUserInfo(@RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex,
                                 @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        // 分页参数
        IPage<UserDetailDTO> page = new Page<>(pageIndex, pageSize);
        // 多表queryWrapper分页查询，若为单表，直接用selectPage即可
        IPage<UserDetailDTO> pageResult = this.userMapper.listUserDetail(page, new QueryWrapper<UserDetailDTO>()
                .like("a.username", "dada").orderByAsc("a.id"));
        LOGGER.info("success...");
        return "success";
    }
}
