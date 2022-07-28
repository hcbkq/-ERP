package com.zhang.rep.service.ex;

/**
 * 地址异常
 */
public class AddressCodeException extends ServiceException{
    public AddressCodeException() {
    }

    public AddressCodeException(String message) {
        super(message);
    }

    public AddressCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCodeException(Throwable cause) {
        super(cause);
    }

    public AddressCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
