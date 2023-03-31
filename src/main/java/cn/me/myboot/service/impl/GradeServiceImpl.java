package cn.me.myboot.service.impl;

import cn.me.myboot.mapper.GradeMapper;
import cn.me.myboot.model.dto.UserGradeDetailDTO;
import cn.me.myboot.model.po.GradePO;
import cn.me.myboot.service.GradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 成绩表 服务实现类
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, GradePO> implements GradeService {

    /**
     * 成绩表 Mapper
     */
    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 分页查询用户得分信息
     *
     * @param pageIndex 当前页
     * @param pageSize  每页条数
     * @return 用户得分信息
     */
    @Override
    public List<UserGradeDetailDTO> listUserGradeDetail(Integer pageIndex, Integer pageSize) {
        // 分页参数
        IPage<UserGradeDetailDTO> page = new Page<>(pageIndex, pageSize);
        // 若为多表，自定义分页查询
        IPage<UserGradeDetailDTO> pageResult = this.gradeMapper.listUserGradeDetail(page, new QueryWrapper<UserGradeDetailDTO>()
                .like("u.user_name", "23").orderByAsc("u.id"));
        return pageResult.getRecords();
    }

}
