package com.zhang.rep.service.ex.account;

import com.zhang.rep.service.ex.ServiceException;

public class UpdateAccountException extends ServiceException {
    public UpdateAccountException() {
    }

    public UpdateAccountException(String message) {
        super(message);
    }

    public UpdateAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateAccountException(Throwable cause) {
        super(cause);
    }

    public UpdateAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
