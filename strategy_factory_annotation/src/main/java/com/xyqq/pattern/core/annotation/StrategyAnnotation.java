package com.xyqq.pattern.core.annotation;

import java.lang.annotation.*;
import com.xyqq.pattern.core.enums.AlgorithmEnum;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrategyAnnotation {

    AlgorithmEnum[] value();
}
