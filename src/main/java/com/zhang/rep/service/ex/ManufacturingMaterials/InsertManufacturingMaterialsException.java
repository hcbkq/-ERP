package com.zhang.rep.service.ex.ManufacturingMaterials;

import com.zhang.rep.service.ex.ServiceException;

public class InsertManufacturingMaterialsException extends ServiceException {
    public InsertManufacturingMaterialsException() {
    }

    public InsertManufacturingMaterialsException(String message) {
        super(message);
    }

    public InsertManufacturingMaterialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertManufacturingMaterialsException(Throwable cause) {
        super(cause);
    }

    public InsertManufacturingMaterialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
