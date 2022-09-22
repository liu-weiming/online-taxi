package com.lwm.service;

import com.lwm.http.ResponseResult;

/**
 * @author weeming
 * @date 2022/9/17 16:44
 */
public interface IVerificationCodeService {
    /**
     * 生成验证码
     * @param passengerPhone 乘客手机号
     * @return 验证码
     */
    ResponseResult<?> generateCode(String passengerPhone);
}
