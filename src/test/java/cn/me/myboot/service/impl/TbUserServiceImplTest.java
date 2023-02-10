package cn.me.myboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import cn.me.myboot.mapper.TbUserMapper;
import cn.me.myboot.model.dto.UserDetailDTO;
import cn.me.myboot.model.po.TbUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbUserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TbUserServiceImplTest {
    @MockBean
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbUserServiceImpl tbUserServiceImpl;

    /**
     * Method under test: {@link TbUserServiceImpl#listUserDetail(Integer, Integer, Boolean)}
     */
    @Test
    void testListUserDetail() {
        when(tbUserMapper.listUserDetail((IPage<UserDetailDTO>) any(), (QueryWrapper<UserDetailDTO>) any()))
                .thenReturn(new Page<>());
        tbUserServiceImpl.listUserDetail(1, 3, true);
        verify(tbUserMapper).listUserDetail((IPage<UserDetailDTO>) any(), (QueryWrapper<UserDetailDTO>) any());
    }

    /**
     * Method under test: {@link TbUserServiceImpl#listUserDetail(Integer, Integer, Boolean)}
     */
    @Test
    void testListUserDetail2() {
        when(tbUserMapper.listUserDetail((IPage<UserDetailDTO>) any(), (QueryWrapper<UserDetailDTO>) any()))
                .thenReturn(new Page<>());
        tbUserServiceImpl.listUserDetail(1, 3, false);
        Class<TbUser> expectedEntityClass = TbUser.class;
        assertSame(expectedEntityClass, tbUserServiceImpl.getEntityClass());
    }
}

