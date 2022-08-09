package cn.me.myboot.controller;

import cn.me.myboot.model.po.TbUser;
import cn.me.myboot.service.TbUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller
 *
 * @author 李心达
 * @since 2022-08-09 08:04:18
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    private TbUserService userService;

    @PostMapping("/select")
    public String selectUserInfo() {
        List<TbUser> userList = this.userService.list();
        return userList.toString();
    }
}
