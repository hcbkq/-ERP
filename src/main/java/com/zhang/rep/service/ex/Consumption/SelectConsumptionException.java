package com.zhang.rep.service.ex.Consumption;

import com.zhang.rep.service.ex.ServiceException;

public class SelectConsumptionException extends ServiceException {
    public SelectConsumptionException() {
    }

    public SelectConsumptionException(String message) {
        super(message);
    }

    public SelectConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectConsumptionException(Throwable cause) {
        super(cause);
    }

    public SelectConsumptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
