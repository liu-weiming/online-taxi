package com.lwm.enums;

import lombok.Getter;

/**
 * @author weeming
 * @date 2022/9/22 11:33
 */
@Getter
public enum ResponseStatusEnum {
    /**
     * 响应成功
     */
    OK(200, "success"),

    FAIL(400, "");

    private final int code;
    private final String msg;

    ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
