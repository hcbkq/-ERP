package com.zhang.rep.service.ex.incomeAndExpenditure;

import com.zhang.rep.service.ex.ServiceException;

public class NotIncomeAndExpenditureException extends ServiceException {
    public NotIncomeAndExpenditureException() {
    }

    public NotIncomeAndExpenditureException(String message) {
        super(message);
    }

    public NotIncomeAndExpenditureException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotIncomeAndExpenditureException(Throwable cause) {
        super(cause);
    }

    public NotIncomeAndExpenditureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
