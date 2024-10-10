package com.product.app.validation;

import com.product.app.dataaccess.entities.InventoryStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class InventoryStatusValidator implements ConstraintValidator<ValidInventoryStatus, InventoryStatus> {

    @Override
    public boolean isValid(InventoryStatus inventoryStatus, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(InventoryStatus.values()).anyMatch(status -> status.name().equals(inventoryStatus.name()));
    }
}
