package com.fullcycle.admin.catalogo.application;

public abstract class UnitUseCase<IN> {

    public abstract void execute(IN anIn);

    //o correto é sempre retornar algo. pq pode indicar um método que faz um efeito indesejado
    // porém pode ocorrer de termos casos de uso que não retornem nada
}
