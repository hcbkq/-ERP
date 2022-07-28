package com.zhang.rep.service.ex.warehousing;

import com.zhang.rep.service.ex.ServiceException;

public class DeleteWarehousingException extends ServiceException {
    public DeleteWarehousingException() {
    }

    public DeleteWarehousingException(String message) {
        super(message);
    }

    public DeleteWarehousingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteWarehousingException(Throwable cause) {
        super(cause);
    }

    public DeleteWarehousingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
