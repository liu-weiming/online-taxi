package com.lwm.controller;

import com.lwm.dto.VerificationCodeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weeming
 * @date 2022/9/17 15:50
 */
@RestController
public class VerificationCodeController {

    @GetMapping("/verification-code")
    public String verificationCode(@RequestBody VerificationCodeDTO dto) {
        //generate verification code

        //send to third party message provider

        //redis cache

        return "";
    }

}
