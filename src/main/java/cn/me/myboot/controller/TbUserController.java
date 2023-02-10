package cn.me.myboot.controller;

import cn.me.myboot.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TbUserController {

    @Autowired
    private TbUserService userService;

    @PostMapping("/select")
    @ApiOperation(value = "分页查询用户信息接口",
            notes = "<span style='color:red;'>描述:</span>用来分页查询用户信息的接口")
    public String selectUserInfo(@RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex,
                                 @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                 @RequestParam(value = "selectFlag", defaultValue = "false", required = false) Boolean selectFlag) {
        // if (selectFlag) {
        //     // 分页参数
        //     IPage<UserDetailDTO> page = new Page<>(pageIndex, pageSize);
        //     // 多表queryWrapper分页查询，若为单表，直接用selectPage即可
        //     IPage<UserDetailDTO> pageResult = this.userMapper.listUserDetail(page, new QueryWrapper<UserDetailDTO>()
        //             .like("a.username", "dada").orderByAsc("a.id"));
        //     log.info("selected...");
        // } else {
        //     log.info("not selected...");
        // }
        this.userService.listUserDetail(pageIndex, pageSize, selectFlag);
        return "success";
    }
}
