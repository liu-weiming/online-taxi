package com.lwm.remote;

import com.lwm.http.ResponseResult;
import com.lwm.http.response.KV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author weeming
 * @date 2022/9/22 12:01
 */
@FeignClient("verification-code-service")
public interface VerificationCodeClient {

    /**
     * feign远程调用获取验证码
     * @return 6位验证码
     */
    @RequestMapping(method = RequestMethod.GET, value = "/verification-code/6")
    ResponseResult<KV> getVerificationCode();

}
