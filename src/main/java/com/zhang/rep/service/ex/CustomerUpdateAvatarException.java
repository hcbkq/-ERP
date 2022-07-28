package com.zhang.rep.service.ex;

/**
 * 修改客户头像
 */
public class CustomerUpdateAvatarException extends ServiceException{
    public CustomerUpdateAvatarException() {
    }

    public CustomerUpdateAvatarException(String message) {
        super(message);
    }

    public CustomerUpdateAvatarException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerUpdateAvatarException(Throwable cause) {
        super(cause);
    }

    public CustomerUpdateAvatarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
