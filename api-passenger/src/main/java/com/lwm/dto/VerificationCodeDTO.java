package com.lwm.dto;

/**
 * @author weeming
 * @date 2022/9/17 15:55
 */
public class VerificationCodeDTO {

    private String passengerPhone;

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    @Override
    public String toString() {
        return "VerificationCodeDTO{" +
                "passengerPhone='" + passengerPhone + '\'' +
                '}';
    }
}
