package com.zhang.rep.service.ex.Consumption;

import com.zhang.rep.service.ex.ServiceException;

public class InsertConsumptionException extends ServiceException {
    public InsertConsumptionException() {
    }

    public InsertConsumptionException(String message) {
        super(message);
    }

    public InsertConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertConsumptionException(Throwable cause) {
        super(cause);
    }

    public InsertConsumptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
