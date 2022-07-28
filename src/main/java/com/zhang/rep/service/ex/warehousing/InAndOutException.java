package com.zhang.rep.service.ex.warehousing;

import com.zhang.rep.service.ex.ServiceException;

public class InAndOutException extends ServiceException {
    public InAndOutException() {
    }

    public InAndOutException(String message) {
        super(message);
    }

    public InAndOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public InAndOutException(Throwable cause) {
        super(cause);
    }

    public InAndOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
