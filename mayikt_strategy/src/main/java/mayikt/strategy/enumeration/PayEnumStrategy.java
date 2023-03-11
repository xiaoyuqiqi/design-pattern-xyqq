package mayikt.strategy.enumeration;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: PayEnumStrategy
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/816:27
 */
public enum PayEnumStrategy {

    /**
     *  支付宝支付
     */
    ALI_PAY("com.mayikt.strategy.impl.AliPayStrategy"),
    /**
     *  银联支付
     */
    UNION_PAY("com.mayikt.strategy.impl.UnionPayStrategy");
    PayEnumStrategy(String className) {
        this.setClassName(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * class完整地址
     */
    private String className;

}
