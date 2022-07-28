package com.zhang.rep.service.ex.ManufacturingMaterials;

import com.zhang.rep.service.ex.ServiceException;

public class SelectManufacturingMaterialsException extends ServiceException {
    public SelectManufacturingMaterialsException() {
    }

    public SelectManufacturingMaterialsException(String message) {
        super(message);
    }

    public SelectManufacturingMaterialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectManufacturingMaterialsException(Throwable cause) {
        super(cause);
    }

    public SelectManufacturingMaterialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
