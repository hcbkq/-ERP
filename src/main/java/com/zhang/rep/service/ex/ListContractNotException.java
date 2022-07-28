package com.zhang.rep.service.ex;

/**
 * 返回合同异常
 */
public class ListContractNotException extends ServiceException{
    public ListContractNotException() {
    }

    public ListContractNotException(String message) {
        super(message);
    }

    public ListContractNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListContractNotException(Throwable cause) {
        super(cause);
    }

    public ListContractNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
