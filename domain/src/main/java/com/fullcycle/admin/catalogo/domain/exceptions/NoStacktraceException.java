package com.fullcycle.admin.catalogo.domain.exceptions;

public class NoStacktraceException extends RuntimeException {
    //Demos um incremento na runtime, para não logar a stacktrace toda do erro
    //e as exception herdam de Nostack

    public NoStacktraceException(final String message) {
        this(message, null);
    }

    public NoStacktraceException(final String message, final Throwable cause) {
        super(message, cause, true, false);
        // não iremos imprimir a stacktrace toda pelo desempenho
        // e como vamos ter um nivel alto de granularidade das exceptions que dizem qual problema, não preciso da stack toda
    }
}
