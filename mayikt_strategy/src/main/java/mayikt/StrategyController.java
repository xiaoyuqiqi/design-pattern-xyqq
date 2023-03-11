package mayikt;

import com.mayikt.strategy.context.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: StrategyController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/816:47
 */
@RestController
public class StrategyController {
    @Autowired
    private PayContextStrategy payContextStrategy;

    @RequestMapping("/toPayHtml")
    public String toPayHtml(String payCode) {
        return  payContextStrategy.toPayDbHtml(payCode);
    }
    public  String toPayHtml2(String payCode){
        if(payCode.equals("ali_pay")){
            return  "调用支付宝接口...";
        }
        if(payCode.equals("xiaomi_pay")){
            return  "调用小米支付接口";
        }
        if(payCode.equals("yinlian_pay")){
            return  "调用银联支付接口...";
        }
        if(payCode.equals("weix_pay")){
            return  "调用微信支付接口....";
        }
        return  "未找到该接口...";
    }
}
