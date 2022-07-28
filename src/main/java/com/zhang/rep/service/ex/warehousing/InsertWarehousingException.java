package com.zhang.rep.service.ex.warehousing;

import com.zhang.rep.service.ex.ServiceException;

public class InsertWarehousingException extends ServiceException {
    public InsertWarehousingException() {
    }

    public InsertWarehousingException(String message) {
        super(message);
    }

    public InsertWarehousingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertWarehousingException(Throwable cause) {
        super(cause);
    }

    public InsertWarehousingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
