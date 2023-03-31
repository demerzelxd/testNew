package cn.me.myboot.util.generator;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * mybatis生成器
 *
 * @author 李心达
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        // 数据源配置
        FastAutoGenerator.create("jdbc:postgresql://52.194.25.20:5432/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
                        "giskard", "Getschwifty42!")
                .globalConfig(builder -> builder.disableOpenDir()
                        .outputDir(System.getProperty("user.dir") + "/src/main/java")
                        .author("lixinda")
                        // .enableKotlin()
                        .enableSwagger()
                        // .dateType(DateType.TIME_PACK)
                        .commentDate("yyyy-MM-dd HH:mm:ss"))
                .packageConfig(builder -> builder.parent("cn.me")
                        .moduleName("myboot")
                        .entity("model.po")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .controller("controller")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper")))
                .strategyConfig(builder -> builder.addInclude("tb_user", "tb_subject", "tb_grade")
                        .addTablePrefix("tb_")
                        .entityBuilder()
                        // .superClass(BaseEntity.class)
                        // .disableSerialVersionUID()
                        .enableFileOverride()
                        .enableChainModel()
                        .enableLombok()
                        // .enableRemoveIsPrefix()
                        .enableTableFieldAnnotation()
                        // .enableActiveRecord()
                        // .versionColumnName("version")
                        // .versionPropertyName("version")
                        // .logicDeleteColumnName("del_flag")
                        // .logicDeletePropertyName("delFlag")
                        // .naming(NamingStrategy.underline_to_camel)
                        // .columnNaming()
                        .formatFileName("%sPO")
                        .controllerBuilder()
                        .enableFileOverride()
                        .enableHyphenStyle()
                        .enableRestStyle()
                        .formatFileName("%sController")
                        .mapperBuilder()
                        .formatMapperFileName("%sMapper")
                        .formatXmlFileName("%sMapper")
                        .superClass(BaseMapper.class)
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .enableFileOverride()
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        .enableFileOverride())
                .templateConfig(builder -> builder.entity("/templates/entity.java")
                        .service("/templates/service.java")
                        .serviceImpl("/templates/serviceImpl.java")
                        .mapper("/templates/mapper.java")
                        .controller("/templates/controller.java")
                        .xml("/templates/mapper.xml"))
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
