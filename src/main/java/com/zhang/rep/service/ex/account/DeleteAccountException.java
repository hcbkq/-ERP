package com.zhang.rep.service.ex.account;

import com.zhang.rep.service.ex.ServiceException;

public class DeleteAccountException extends ServiceException {
    public DeleteAccountException() {
    }

    public DeleteAccountException(String message) {
        super(message);
    }

    public DeleteAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteAccountException(Throwable cause) {
        super(cause);
    }

    public DeleteAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
