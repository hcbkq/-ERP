package com.zhang.rep.service.ex.incomeAndExpenditure;

import com.zhang.rep.service.ex.ServiceException;

public class UpdateIncomeAndExpenditureException extends ServiceException {
    public UpdateIncomeAndExpenditureException() {
    }

    public UpdateIncomeAndExpenditureException(String message) {
        super(message);
    }

    public UpdateIncomeAndExpenditureException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateIncomeAndExpenditureException(Throwable cause) {
        super(cause);
    }

    public UpdateIncomeAndExpenditureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
