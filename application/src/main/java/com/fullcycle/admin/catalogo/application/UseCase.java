package com.fullcycle.admin.catalogo.application;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);
    /*
    pq execute? Por padrão os casos de uso implementam o pattern command, que possui um unico metodo
    e a implementacoes serao CreateUseCase, FindAllUseCase, etc etc.
     */
}