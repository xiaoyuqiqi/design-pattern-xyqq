package mayikt.strategy.factory;


import mayikt.strategy.PayStrategy;
import mayikt.strategy.enumeration.PayEnumStrategy;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: StrategyFactory  获取具体策略实现
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/816:34
 */
public class StrategyFactory {
    public static PayStrategy getPayStrategy(String strategyType) {
        try {
            // 1.获取枚举中className
            String className = PayEnumStrategy.valueOf(strategyType).getClassName();
            // 2.使用java反射技术初始化类
            return (PayStrategy) Class.forName(className).newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
