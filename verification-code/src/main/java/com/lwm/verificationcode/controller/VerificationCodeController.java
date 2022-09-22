package com.lwm.verificationcode.controller;

import com.lwm.http.ResponseResult;
import com.lwm.http.response.KV;
import com.lwm.verificationcode.service.IVerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weeming
 * @date 2022/9/20 15:12
 */
@RestController
@RequiredArgsConstructor
public class VerificationCodeController {

    private final IVerificationCodeService verificationCodeService;

    @GetMapping("/verification-code/{length}")
    public ResponseResult<KV> generateCode(@PathVariable Integer length) {
        return ResponseResult.success(new KV().put("code", verificationCodeService.getNumericCode(length)));
    }

}
