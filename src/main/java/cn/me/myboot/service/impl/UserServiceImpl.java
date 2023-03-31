package cn.me.myboot.service.impl;

import cn.me.myboot.mapper.UserMapper;
import cn.me.myboot.model.po.UserPO;
import cn.me.myboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

}
