package com.lwm.controller;

import com.lwm.dto.VerificationCodeDTO;
import com.lwm.http.ResponseResult;
import com.lwm.service.IVerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weeming
 * @date 2022/9/17 15:50
 */
@RestController
@RequiredArgsConstructor
public class VerificationCodeController {

    private final IVerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult<?> verificationCode(@RequestBody VerificationCodeDTO dto) {
        System.out.println("Received passengerPhone is: " + dto.getPassengerPhone());

        return verificationCodeService.generateCode(dto.getPassengerPhone());
    }

}
