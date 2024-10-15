package com.xyqq.pattern;

import com.xyqq.pattern.core.enums.AlgorithmEnum;
import com.xyqq.pattern.service.factory.StrategyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StrategyFactoryAnnotationApplicationTests {

    @Resource
    private StrategyFactory strategyFactory;

    @Test
    void contextLoads() {
        System.out.println(strategyFactory.get(AlgorithmEnum.ALGORITHM2).encrypt("xxx"));
    }

}
