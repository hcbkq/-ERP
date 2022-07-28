package com.zhang.rep.service.ex;

/**
 * 创建合同错误
 */
public class InsertNewContractException extends ServiceException{
    public InsertNewContractException() {
    }

    public InsertNewContractException(String message) {
        super(message);
    }

    public InsertNewContractException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertNewContractException(Throwable cause) {
        super(cause);
    }

    public InsertNewContractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
