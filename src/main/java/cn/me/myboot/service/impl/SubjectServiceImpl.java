package cn.me.myboot.service.impl;

import cn.me.myboot.model.po.SubjectPO;
import cn.me.myboot.mapper.SubjectMapper;
import cn.me.myboot.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 科目表 服务实现类
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, SubjectPO> implements SubjectService {

}
