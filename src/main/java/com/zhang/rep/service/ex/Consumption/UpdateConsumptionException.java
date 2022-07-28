package com.zhang.rep.service.ex.Consumption;

import com.zhang.rep.service.ex.ServiceException;

public class UpdateConsumptionException extends ServiceException {
    public UpdateConsumptionException() {
    }

    public UpdateConsumptionException(String message) {
        super(message);
    }

    public UpdateConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateConsumptionException(Throwable cause) {
        super(cause);
    }

    public UpdateConsumptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
