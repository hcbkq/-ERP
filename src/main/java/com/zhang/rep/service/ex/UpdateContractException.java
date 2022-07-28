package com.zhang.rep.service.ex;

/**
 * 修改合同异常
 */
public class UpdateContractException extends ServiceException{
    public UpdateContractException() {
    }

    public UpdateContractException(String message) {
        super(message);
    }

    public UpdateContractException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateContractException(Throwable cause) {
        super(cause);
    }

    public UpdateContractException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
