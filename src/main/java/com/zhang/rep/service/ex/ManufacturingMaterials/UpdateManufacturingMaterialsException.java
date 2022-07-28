package com.zhang.rep.service.ex.ManufacturingMaterials;

import com.zhang.rep.service.ex.ServiceException;

public class UpdateManufacturingMaterialsException extends ServiceException {
    public UpdateManufacturingMaterialsException() {
    }

    public UpdateManufacturingMaterialsException(String message) {
        super(message);
    }

    public UpdateManufacturingMaterialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateManufacturingMaterialsException(Throwable cause) {
        super(cause);
    }

    public UpdateManufacturingMaterialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
