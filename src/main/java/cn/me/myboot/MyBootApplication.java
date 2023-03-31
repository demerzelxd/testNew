package cn.me.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author 李心达
 */
@SpringBootApplication
@MapperScan("cn.me.myboot.mapper")
public class MyBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class, args);
    }
}
