package com.campusbike.campusbike.validation.campo;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ControllerAdvice
public class FieldEmptyException {
    private String field;
    private String error;

    @SuppressWarnings("null")
    public static FieldEmptyException getError(BindingResult result) {

        FieldEmptyException fieldEmptyException = new FieldEmptyException();
        FieldError error = result.getFieldError();

        fieldEmptyException.field = error.getField();
        fieldEmptyException.error = error.getDefaultMessage();

        return fieldEmptyException;
    }
}
