package com.zhang.rep.service.ex;

/**
 * 结单错误
 */
public class UpdateStatementException extends ServiceException{
    public UpdateStatementException() {
    }

    public UpdateStatementException(String message) {
        super(message);
    }

    public UpdateStatementException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateStatementException(Throwable cause) {
        super(cause);
    }

    public UpdateStatementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
