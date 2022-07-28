package com.zhang.rep.service.ex.account;

import com.zhang.rep.service.ex.ServiceException;

public class LackOfMoneyException extends ServiceException {
    public LackOfMoneyException() {
    }

    public LackOfMoneyException(String message) {
        super(message);
    }

    public LackOfMoneyException(String message, Throwable cause) {
        super(message, cause);
    }

    public LackOfMoneyException(Throwable cause) {
        super(cause);
    }

    public LackOfMoneyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
