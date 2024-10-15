# 这是一个策略模式+工厂模式+自定义注解的demo

## 模块介绍
假设有一个需求，需要根据不同的算法实现对字符串的加密，那么我们可以使用策略模式来实现。

### 策略模块

* com/xyqq/pattern/service/strategy
* com/xyqq/pattern/service/strategy/impl


### 工厂模块

* com/xyqq/pattern/service/factory

### 自定义注解模块

* com/xyqq/pattern/core/annotation/StrategyAnnotation.java