package com.linciping.library.exception;

import com.linciping.library.constant.MessageConstant;

/**
 * @author linciping
 * @time 2017/9/11
 * @note 权限异常
 */
public class PermissionException extends Exception {

    public PermissionException() {
        super(MessageConstant.PERMISSION_NO_ALLOW);
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }
}
