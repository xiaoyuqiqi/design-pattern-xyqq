package hanlder.impl;

import hanlder.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: CurrentLimitHandler
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:25
 */
@Component
public class CurrentLimitHandler extends GatewayHandler {
    public void service() {
        System.out.println("第一关>>Api接口限流>>");
        nextService();
        ;
    }
}
