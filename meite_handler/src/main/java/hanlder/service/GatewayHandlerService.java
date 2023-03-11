package hanlder.service;

import com.mayikt.hanlder.GatewayHandler;
import com.mayikt.hanlder.mapper.GatewayHandlerMapper;
import com.mayikt.hanlder.mapper.entity.GatewayHandlerEntity;
import com.mayikt.hanlder.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: GatewayHandlerService
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/1218:53
 */
@Component
public class GatewayHandlerService {
    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;
    private GatewayHandler firstGatewayHandler;

    public GatewayHandler getDbFirstGatewayHandler() {
        if (this.firstGatewayHandler != null) {
            return this.firstGatewayHandler;
        }
        // 1.查询数据库第一个handler配置
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if (firstGatewayHandlerEntity == null) {
            return null;
        }
        String firstBeanHandlerId = firstGatewayHandlerEntity.getHandlerId();
        if (StringUtils.isEmpty(firstBeanHandlerId)) {
            return null;
        }
        // 2.从SpringBoot容器获取第一个handler对象
        GatewayHandler firstGatewayHandler = SpringUtils.getBean(firstBeanHandlerId, GatewayHandler.class);
        if (firstGatewayHandler == null) {
            return null;
        }
        // 3. 获取下一个handlerBeanId
        String nextBeanHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        // 定义临时循环遍历指针
        GatewayHandler tempNextGatewayHandler = firstGatewayHandler;
        while (!StringUtils.isEmpty(nextBeanHandlerId)) {
            // 4.从SpringBoot容器获取下一个handler对象
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextBeanHandlerId, GatewayHandler.class);
            if (nextGatewayHandler == null) {
                break;
            }
            // 5.从数据库查询该hanlder信息
            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getByHandler(nextBeanHandlerId);
            if (nextGatewayHandlerEntity == null) {
                break;
            }
            // 6.设置下一个white循环遍历hanlderid
            nextBeanHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            tempNextGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            tempNextGatewayHandler = nextGatewayHandler;
        }
        this.firstGatewayHandler = firstGatewayHandler;
        return firstGatewayHandler;
    }
}
