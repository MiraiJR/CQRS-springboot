package com.miraijr.query_side.application.modules.product.exceptions;

import com.miraijr.query_side.shared.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

public class CanNotSearchProduct extends ApplicationException {
    public CanNotSearchProduct() {
        super("PRODUCT-ERROR-0001", "Can not search product", HttpStatus.BAD_REQUEST);
    }
}
