package com.lwm.http;

import com.lwm.enums.ResponseStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author weeming
 * @date 2022/9/22 10:55
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>()
                .setCode(ResponseStatusEnum.OK.getCode())
                .setMsg(ResponseStatusEnum.OK.getMsg());
    }

    public static <T> ResponseResult<T> success(String msg) {
        return new ResponseResult<T>().setCode(ResponseStatusEnum.OK.getCode()).setMsg(msg);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>().setCode(ResponseStatusEnum.OK.getCode())
                .setMsg(ResponseStatusEnum.OK.getMsg())
                .setData(data);
    }

    public static <T> ResponseResult<T> fail(String msg) {
        return new ResponseResult<T>().setCode(400).setMsg(msg);
    }

    public static <T> ResponseResult<T> fail(int code, String msg) {
        return new ResponseResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ResponseResult<T> status(boolean success) {
        return new ResponseResult<T>().setCode(success ? ResponseStatusEnum.OK.getCode() : ResponseStatusEnum.FAIL.getCode());
    }

    public boolean isSuccess() {
        return code == ResponseStatusEnum.OK.getCode();
    }

}
