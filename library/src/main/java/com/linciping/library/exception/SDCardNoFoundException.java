package com.linciping.library.exception;

import com.linciping.library.constant.MessageConstant;

import java.io.IOException;

/**
 * @author linciping
 * @time 2017/9/11
 * @note SD卡不存在异常
 */
public class SDCardNoFoundException extends IOException {

    public SDCardNoFoundException() {
        super(MessageConstant.SDCARD_NO_EXIST);
    }

    public SDCardNoFoundException(String message) {
        super(message);
    }

    public SDCardNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SDCardNoFoundException(Throwable cause) {
        super(cause);
    }
}
