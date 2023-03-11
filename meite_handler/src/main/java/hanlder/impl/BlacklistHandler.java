package hanlder.impl;

import com.mayikt.hanlder.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: BlacklistHandler
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:28
 */
@Component
public class BlacklistHandler extends GatewayHandler {
    public void service() {
        System.out.println("第二关>>黑名单拦截>>");
        nextService();
    }
}
