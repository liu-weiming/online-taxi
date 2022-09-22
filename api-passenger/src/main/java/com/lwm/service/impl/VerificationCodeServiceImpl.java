package com.lwm.service.impl;

import com.lwm.exception.ServiceException;
import com.lwm.http.ResponseResult;
import com.lwm.http.response.KV;
import com.lwm.remote.VerificationCodeClient;
import com.lwm.service.IVerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author weeming
 * @date 2022/9/17 16:44
 */
@Service
@RequiredArgsConstructor
public class VerificationCodeServiceImpl implements IVerificationCodeService {

    private final VerificationCodeClient verificationCodeClient;

    @Override
    public ResponseResult<?> generateCode(String passengerPhone) {
        // 调用验证码服务，获取验证码
        final ResponseResult<KV> vcResponse = verificationCodeClient.getVerificationCode();
        if (!vcResponse.isSuccess()) {
            throw new ServiceException(vcResponse.getCode(), "获取验证码失败：" + vcResponse.getMsg());
        }
        // 存redis
        System.out.println("存Redis");

        return vcResponse;
    }

}
