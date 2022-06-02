package cn.me.myboot.service.impl;

import cn.me.myboot.model.po.User;
import cn.me.myboot.mapper.UserMapper;
import cn.me.myboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Giskard
 * @since 2022-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
