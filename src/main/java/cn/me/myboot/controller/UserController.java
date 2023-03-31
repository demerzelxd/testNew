package cn.me.myboot.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 前端控制器
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户Controller")
@Slf4j
public class UserController {

}
