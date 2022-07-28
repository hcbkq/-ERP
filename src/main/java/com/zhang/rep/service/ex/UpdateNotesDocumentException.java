package com.zhang.rep.service.ex;

/**
 * 修改订单备注错误
 */
public class UpdateNotesDocumentException extends ServiceException{
    public UpdateNotesDocumentException() {
    }

    public UpdateNotesDocumentException(String message) {
        super(message);
    }

    public UpdateNotesDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateNotesDocumentException(Throwable cause) {
        super(cause);
    }

    public UpdateNotesDocumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
