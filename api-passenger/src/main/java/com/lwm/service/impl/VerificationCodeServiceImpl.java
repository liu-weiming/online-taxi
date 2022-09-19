package com.lwm.service.impl;

import com.lwm.service.IVerificationCodeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author weeming
 * @date 2022/9/17 16:44
 */
@Service
public class VerificationCodeServiceImpl implements IVerificationCodeService {

    public String generateCode(String passengerPhone) {
        // 调用验证码服务，获取验证码
        String code = "123456";

        // 存redis
        System.out.println("存Redis");


        return code;
    }

}
