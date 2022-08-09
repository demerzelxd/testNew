package cn.me.myboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.me.myboot.model.po.TbUser;
import cn.me.myboot.service.TbUserService;
import cn.me.myboot.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

/**
* Impl
*
* @author 李心达
* @since 2022-08-09 09:36:59
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
    implements TbUserService{

}




