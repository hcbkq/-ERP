package com.zhang.rep.service.ex.account;

import com.zhang.rep.service.ex.ServiceException;

public class InsertAccountException extends ServiceException {
    public InsertAccountException() {
    }

    public InsertAccountException(String message) {
        super(message);
    }

    public InsertAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertAccountException(Throwable cause) {
        super(cause);
    }

    public InsertAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
