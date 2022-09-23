package com.lwm.service.impl;

import com.lwm.constant.VerificationConst;
import com.lwm.dto.VerificationCodeDTO;
import com.lwm.exception.ServiceException;
import com.lwm.http.ResponseResult;
import com.lwm.http.response.KV;
import com.lwm.remote.VerificationCodeClient;
import com.lwm.service.IVerificationCodeService;
import com.lwm.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author weeming
 * @date 2022/9/17 16:44
 */
@Service
@RequiredArgsConstructor
public class VerificationCodeServiceImpl implements IVerificationCodeService {

    private final VerificationCodeClient verificationCodeClient;
    private final StringRedisTemplate redisTemplate;

    @Override
    public ResponseResult<?> generateCode(String passengerPhone) {
        // 调用验证码服务，获取验证码
        final ResponseResult<KV> vcResponse = verificationCodeClient.getVerificationCode();
        if (!vcResponse.isSuccess()) {
            throw new ServiceException(vcResponse.getCode(), "获取验证码失败：" + vcResponse.getMsg());
        }
        // 存redis
        final String code = String.valueOf(vcResponse.getData().get("code"));
        redisTemplate.opsForValue().set(String.format(VerificationConst.PASSENGER_KEY, passengerPhone), code, 2, TimeUnit.MINUTES);

        return vcResponse;
    }

    @Override
    public boolean verify(VerificationCodeDTO dto) {
        final String passengerPhone = dto.getPassengerPhone();
        final String code = dto.getCode();
        if (StringUtil.isBlank(passengerPhone) || StringUtil.isBlank(code)) {
            return false;
        }
        final String cacheCode = redisTemplate.opsForValue().get(String.format(VerificationConst.PASSENGER_KEY, passengerPhone));
        final boolean matches = code.equals(cacheCode);
        if (matches) {
            redisTemplate.delete(passengerPhone);
        }
        return matches;
    }

}
