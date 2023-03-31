package cn.me.myboot.controller;

import cn.me.myboot.model.dto.UserGradeDetailDTO;
import cn.me.myboot.service.GradeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 成绩表 前端控制器
 *
 * @author lixinda
 * @since 2023-03-31 14:13:14
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    /**
     * 分页查询用户得分信息
     *
     * @param pageIndex 当前页
     * @param pageSize  每页条数
     * @return 用户得分信息
     */
    @PostMapping("/list")
    @ApiOperation(value = "分页查询用户信息接口",
            notes = "<span style='color:red;'>描述:</span>用来分页查询用户得分信息的接口")
    public List<UserGradeDetailDTO> listUserGradeDetail(@RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex,
                                                        @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return this.gradeService.listUserGradeDetail(pageIndex, pageSize);
    }
}
