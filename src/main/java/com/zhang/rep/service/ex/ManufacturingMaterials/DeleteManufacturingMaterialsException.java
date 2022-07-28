package com.zhang.rep.service.ex.ManufacturingMaterials;

import com.zhang.rep.service.ex.ServiceException;

public class DeleteManufacturingMaterialsException extends ServiceException {
    public DeleteManufacturingMaterialsException() {
    }

    public DeleteManufacturingMaterialsException(String message) {
        super(message);
    }

    public DeleteManufacturingMaterialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteManufacturingMaterialsException(Throwable cause) {
        super(cause);
    }

    public DeleteManufacturingMaterialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
