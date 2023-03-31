package cn.me.myboot.service;

import cn.me.myboot.model.dto.UserGradeDetailDTO;
import cn.me.myboot.model.po.GradePO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 成绩表 服务类
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
public interface GradeService extends IService<GradePO> {

    /**
     * 分页查询用户得分信息
     *
     * @param pageIndex 当前页
     * @param pageSize 每页条数
     * @return 用户得分信息
     */
    List<UserGradeDetailDTO> listUserGradeDetail(Integer pageIndex, Integer pageSize);
}
