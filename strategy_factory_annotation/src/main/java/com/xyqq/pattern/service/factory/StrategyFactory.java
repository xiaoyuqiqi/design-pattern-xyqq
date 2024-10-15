package com.xyqq.pattern.service.factory;

import com.xyqq.pattern.core.annotation.StrategyAnnotation;
import com.xyqq.pattern.core.enums.AlgorithmEnum;
import com.xyqq.pattern.service.strategy.Strategy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StrategyFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final Map<AlgorithmEnum, Strategy> checkStrategyMap = new HashMap<>();
    private Map<String, Strategy> strategyBeans;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Strategy get(AlgorithmEnum algorithmEnum) {
        return checkStrategyMap.get(algorithmEnum);
    }

    @PostConstruct
    public void postConstruct() {
        if (strategyBeans == null) {
            strategyBeans = applicationContext.getBeansOfType(Strategy.class);
        }

        for (Strategy strategy : strategyBeans.values()) {
            if (strategy.getClass().isAnnotationPresent(StrategyAnnotation.class)) {
                StrategyAnnotation annotation = strategy.getClass().getAnnotation(StrategyAnnotation.class);
                AlgorithmEnum[] algorithmEnums = annotation.value();
                if (algorithmEnums.length > 0) {
                    for (AlgorithmEnum algorithmEnum : algorithmEnums) {
                        checkStrategyMap.putIfAbsent(algorithmEnum, strategy);
                    }
                }
            }
        }
    }
}
