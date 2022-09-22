package com.lwm.verificationcode.service.impl;

import com.lwm.exception.ServiceException;
import com.lwm.verificationcode.service.IVerificationCodeService;
import org.springframework.stereotype.Service;

/**
 * @author weeming
 * @date 2022/9/20 15:15
 */
@Service
public class VerificationCodeServiceImpl implements IVerificationCodeService {

    /**
     * 数值型随机数的最大长度
     */
    private final static int MAX_NUMERIC_LENGTH = 19;

    @Override
    @SuppressWarnings("all")
    public long getNumericCode(Integer length) {
        if (null == length) {
            throw new ServiceException("长度不能为空");
        }
        if (length <= 0) {
            throw new ServiceException("长度不能小于等于0");
        }
        if (length > MAX_NUMERIC_LENGTH) {
            throw new ServiceException("长度超出数值类型范围");
        }
        long code = 0;
        double digits = Math.pow(10, length);
        while (code < (digits / 10 - 1)) {
            code = (long) (Math.random() * digits);
        }
        return code;
    }

}
