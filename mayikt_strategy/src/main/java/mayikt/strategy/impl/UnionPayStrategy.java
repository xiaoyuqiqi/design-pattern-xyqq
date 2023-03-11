package mayikt.strategy.impl;

import com.mayikt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: AliPayStrategy
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/816:17
 */
@Component
public class UnionPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用银联支付接口....";
    }
}
