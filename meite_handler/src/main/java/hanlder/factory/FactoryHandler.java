package hanlder.factory;

import com.mayikt.hanlder.GatewayHandler;
import com.mayikt.hanlder.impl.BlacklistHandler;
import com.mayikt.hanlder.impl.ConversationHandler;
import com.mayikt.hanlder.impl.CurrentLimitHandler;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: FactoryHandler
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:35
 */
public class FactoryHandler {

    public static GatewayHandler getFirstGatewayHandler() {
        GatewayHandler gatewayHandler1 = new CurrentLimitHandler();
        GatewayHandler gatewayHandler2 = new BlacklistHandler();
        gatewayHandler1.setNextGatewayHandler(gatewayHandler2);
        GatewayHandler gatewayHandler3 = new ConversationHandler();
        gatewayHandler2.setNextGatewayHandler(gatewayHandler3);
        return gatewayHandler1;
    }
}
