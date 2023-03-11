package hanlder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: AppHanlder
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:49
 */
@SpringBootApplication
@MapperScan("com.mayikt.hanlder.mapper")
public class AppHanlder {
    public static void main(String[] args) {
        SpringApplication.run(AppHanlder.class);
    }
}
