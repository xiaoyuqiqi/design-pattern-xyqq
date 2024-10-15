package com.xyqq.pattern.core.enums;

import lombok.Getter;

@Getter
public enum AlgorithmEnum {
    /**
     * 算法
     */
    ALGORITHM1(1, "算法1"),
    ALGORITHM2(2, "算法2"),
    ALGORITHM3(3, "算法3"),
    ALGORITHM4(4, "算法4");

    private final Integer code;
    private final String desc;

    AlgorithmEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AlgorithmEnum getEnum(Integer code) {
        AlgorithmEnum[] values = values();
        for (AlgorithmEnum value : values) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new RuntimeException("无效的加密加密算法！");
    }
}
