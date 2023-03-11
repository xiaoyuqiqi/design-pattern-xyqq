package hanlder;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: GatewayHandler
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:21
 */
public abstract class GatewayHandler {
    /**
     * 下一个GatewayHandler
     */
    protected GatewayHandler nextGatewayHandler;

    /**
     * 处理业务逻辑
     */
    public abstract void service();

    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

    protected void nextService() {
        if (nextGatewayHandler != null)
            nextGatewayHandler.service();
        ;
    }

}
