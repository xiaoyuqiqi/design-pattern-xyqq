package com.xyqq.pattern.service.strategy.impl;

import com.xyqq.pattern.core.annotation.StrategyAnnotation;
import com.xyqq.pattern.core.enums.AlgorithmEnum;
import com.xyqq.pattern.service.strategy.Strategy;
import org.springframework.stereotype.Component;

@Component
@StrategyAnnotation(AlgorithmEnum.ALGORITHM2)
public class AlgorithmStrategy2 implements Strategy {

    private static final char EMPTY_VALUE = '\u0000';

    @Override
    public String encrypt(String data) {

        return "算法2";
    }


}
