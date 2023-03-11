package mayikt.strategy;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: PayStrategy
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/816:15
 */
public interface PayStrategy {

    /**
     * 定义策略模式共同行为算法骨架
     * @return
     */
    public  String  toPayHtml();

}
