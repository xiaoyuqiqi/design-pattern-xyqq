package hanlder.controller;


import hanlder.GatewayHandler;
import hanlder.service.GatewayHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: HandlerController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:45
 */
@RestController
public class HandlerController {

    @Autowired
    private GatewayHandlerService gatewayHandlerService;

    @RequestMapping("/clentHanlder")
    public String clentHanlder() {
        GatewayHandler firstGatewayHandler = gatewayHandlerService.getDbFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }
}
