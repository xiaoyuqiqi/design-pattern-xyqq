package com.xyqq.pattern.service.strategy;


public interface Strategy {

    /**
     * 数据加密：根据选择的加密方式不同 对数据进行加密
     */
    String encrypt(String data);

}
