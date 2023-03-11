package mayikt.strategy.context;

import mayikt.mapper.PaymentChannelMapper;
import mayikt.mapper.entity.PaymentChannelEntity;
import mayikt.strategy.PayStrategy;
import mayikt.strategy.factory.StrategyFactory;
import mayikt.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: PayContextStrategy
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/816:20
 */
@Component
public class PayContextStrategy {
    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    /**
     * 使用枚举+工厂方式实现策略模式
     *
     * @param payCode
     * @return
     */
    public String toPayEnumHtml(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return "payCode不能为空!";
        }
        PayStrategy payStrategy = StrategyFactory.getPayStrategy(payCode);
        if (payStrategy == null) {
            return "没有查询到该渠道信息";
        }
        // 子类重写父类..
        return payStrategy.toPayHtml();
    }

    public String toPayDbHtml(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return "payCode不能为空!";
        }
        PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(payCode);
        if(paymentChannel==null){
            return "没有查询到该渠道信息";
        }
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        if(strategyBeanId==null){
            return "没有配置策略BeanId";
        }
        // 使用beanid从容器获取对象
        PayStrategy payStrategy= SpringUtils.getBean(strategyBeanId,PayStrategy.class);
        return payStrategy.toPayHtml();
    }
}
