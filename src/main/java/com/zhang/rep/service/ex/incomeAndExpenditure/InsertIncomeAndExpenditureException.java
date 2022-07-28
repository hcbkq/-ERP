package com.zhang.rep.service.ex.incomeAndExpenditure;

import com.zhang.rep.service.ex.ServiceException;

public class InsertIncomeAndExpenditureException extends ServiceException {
    public InsertIncomeAndExpenditureException() {
    }

    public InsertIncomeAndExpenditureException(String message) {
        super(message);
    }

    public InsertIncomeAndExpenditureException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertIncomeAndExpenditureException(Throwable cause) {
        super(cause);
    }

    public InsertIncomeAndExpenditureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
