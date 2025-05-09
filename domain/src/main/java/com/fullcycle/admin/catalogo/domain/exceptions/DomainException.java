package com.fullcycle.admin.catalogo.domain.exceptions;

import com.fullcycle.admin.catalogo.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStacktraceException {

    private final List<Error> errors;

    protected DomainException(final String aMessage, List<Error> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }
    public static DomainException with(final Error aError) {
        return new DomainException(aError.message(), List.of(aError));
    }


    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
