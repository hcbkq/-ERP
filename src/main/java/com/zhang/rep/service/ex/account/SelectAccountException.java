package com.zhang.rep.service.ex.account;

import com.zhang.rep.service.ex.ServiceException;

public class SelectAccountException extends ServiceException {
    public SelectAccountException() {
    }

    public SelectAccountException(String message) {
        super(message);
    }

    public SelectAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectAccountException(Throwable cause) {
        super(cause);
    }

    public SelectAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
