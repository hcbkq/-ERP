package com.zhang.rep.service.ex.warehousing;

import com.zhang.rep.service.ex.ServiceException;

public class SelectWarehousingException extends ServiceException {
    public SelectWarehousingException() {
    }

    public SelectWarehousingException(String message) {
        super(message);
    }

    public SelectWarehousingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectWarehousingException(Throwable cause) {
        super(cause);
    }

    public SelectWarehousingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
