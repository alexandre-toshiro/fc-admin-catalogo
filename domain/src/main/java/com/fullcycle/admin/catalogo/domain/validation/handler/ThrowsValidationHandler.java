package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(Error anError) {
        throw DomainException.with((anError));
    }

    @Override
    public ValidationHandler append(ValidationHandler andHandler) {
        throw DomainException.with(andHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try{
            aValidation.validate();
        } catch (final Exception e){
            throw DomainException.with(new Error(e.getMessage()));
        }
        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
