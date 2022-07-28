package com.zhang.rep.service.ex.incomeAndExpenditure;

import com.zhang.rep.service.ex.ServiceException;

public class DeleteIncomeAndExpenditureException extends ServiceException {
    public DeleteIncomeAndExpenditureException() {
    }

    public DeleteIncomeAndExpenditureException(String message) {
        super(message);
    }

    public DeleteIncomeAndExpenditureException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteIncomeAndExpenditureException(Throwable cause) {
        super(cause);
    }

    public DeleteIncomeAndExpenditureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
