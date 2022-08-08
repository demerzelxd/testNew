package cn.me.myboot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBootApplicationTests {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    void contextLoads() {
        String password = "12345";
        String encryptPwd = encryptor.encrypt(password);
        System.out.println("加密: " + encryptPwd);
        System.out.println("解密: " + encryptor.decrypt(encryptPwd));
    }

}
