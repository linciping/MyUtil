package com.linciping.library.exception;

import com.linciping.library.MessageConstant;

import java.io.IOException;

/**
 * @author linciping
 *         2017/9/11
 */

public class CreateFileException extends IOException {

    public CreateFileException() {
        super(MessageConstant.CREATE_FILE_ERROR);
    }

    public CreateFileException(String message) {
        super(message);
    }

    public CreateFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateFileException(Throwable cause) {
        super(cause);
    }
}
