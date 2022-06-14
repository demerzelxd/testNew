package cn.me.myboot.controller;


import cn.me.myboot.model.po.User;
import cn.me.myboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Giskard
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/select")
    public String selectUserInfo() {
        List<User> userList = this.userService.list();
        return userList.toString();
    }
}
