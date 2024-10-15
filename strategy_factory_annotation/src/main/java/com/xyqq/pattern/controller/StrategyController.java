package com.xyqq.pattern.controller;
import com.xyqq.pattern.service.factory.StrategyFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xyqq.pattern.core.enums.AlgorithmEnum;
import javax.annotation.Resource;

@RestController
public class StrategyController {

    @Resource
    private StrategyFactory strategyFactory;

    @RequestMapping("/test")
    public String test() {
        return strategyFactory.get(AlgorithmEnum.ALGORITHM1).encrypt("xxx");
    }

}
