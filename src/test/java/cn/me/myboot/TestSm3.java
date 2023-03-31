package cn.me.myboot;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * 测试SM3加密
 *
 * @author lixinda
 * @since 2023-03-31 14:20:00
 */
@Slf4j
public class TestSm3 {

    @Test
    public void testManualSm3 () {
        File file = new File("C:\\Users\\lixinda\\Desktop\\用户组分配2.xlsx");
        System.out.println(SM3Util.encrypt(file));
        System.out.println(SmUtil.sm3(file));
        Digester sm3 = DigestUtil.digester("sm3");
        System.out.println(sm3.digestHex(file));
    }

}
