package com.lwm.verificationcode.service;

/**
 * @author weeming
 * @date 2022/9/20 15:14
 */
public interface IVerificationCodeService {
    /**
     * 获取数值型随机数
     * @param length 指定随机数的长度
     * @return 指定长度的随机数
     */
    long getNumericCode(Integer length);
}
