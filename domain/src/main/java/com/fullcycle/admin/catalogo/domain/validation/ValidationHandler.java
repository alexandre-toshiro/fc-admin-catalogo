package com.fullcycle.admin.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {

    //interface fluente ->  Métodos retornam a própria instância, permitindo encadeamento elegante.

    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler anHandler);
    //a ideia deste append é adicionar um outro handler para que possa ser feita uma incrementação aqui(semelhante ao addAll)
    //Adiciona todos os erros de outro ValidationHandler dentro do atual.

    ValidationHandler validate(Validation aValidation);

    List<Error> getErrors();

    default boolean hasErrors() {
        //se tem erros dentro do validation
        return getErrors() != null && !getErrors().isEmpty();
    }

    default Error firstError() {
        if (getErrors() != null && !getErrors().isEmpty()) {
            return getErrors().get(0);
        } else {
            return null;
        }
    }

    public interface Validation {
        //interface funcional para permitir o usoo de lambda no método validade
        void validate();
    }
}
