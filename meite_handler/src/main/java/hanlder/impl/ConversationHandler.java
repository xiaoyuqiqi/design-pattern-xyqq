package hanlder.impl;

import hanlder.GatewayHandler;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: ConversationHandler
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:29
 */
@Component
public class ConversationHandler extends GatewayHandler {
    public void service() {
        System.out.println("第三关>>用户会话拦截判断>>");

    }
}
