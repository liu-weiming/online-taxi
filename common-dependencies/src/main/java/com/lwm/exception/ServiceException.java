package com.lwm.exception;

import com.lwm.enums.ResponseStatusEnum;

/**
 * @author weeming
 * @date 2022/9/22 13:51
 */
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(String errMsg) {
        super(errMsg);
        this.code = ResponseStatusEnum.FAIL.getCode();
    }

    public ServiceException(int code, String errMsg) {
        super(errMsg);
        this.code = code;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
