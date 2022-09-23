package com.lwm.service;

import com.lwm.dto.VerificationCodeDTO;
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

    /**
     * 校验验证码
     * @param dto 手机号验证码
     * @return 是否校验成功
     */
    boolean verify(VerificationCodeDTO dto);
}
