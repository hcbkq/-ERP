package com.zhang.rep.service.ex.warehousing;

import com.zhang.rep.service.ex.ServiceException;

public class UpdateWarehousingException extends ServiceException {
    public UpdateWarehousingException() {
    }

    public UpdateWarehousingException(String message) {
        super(message);
    }

    public UpdateWarehousingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateWarehousingException(Throwable cause) {
        super(cause);
    }

    public UpdateWarehousingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
