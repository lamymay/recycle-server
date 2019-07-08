package com.arc.recycle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * 主启动类，项目将打成jar，使用内置tomcat运行
 * 项目使用SpringBoot2.1.6版本+MybatisPlus+MySQL8.0+(可能后期加入redis)
 *
 * @author X
 */
@MapperScan("com.arc.recycle.mapper.system")
@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class,
        MongoAutoConfiguration.class
})
public class RecycleGarbageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecycleGarbageApplication.class, args);
    }

}

