package com.fullcycle.admin.catalogo.domain.category;

public record CategorySearchQuery(
     int page, //qual a pagina esta sendo buscada
     int perPage, // quantos items por pagina
     String terms, // filtro por um termo especifico
     String sort, // por qual atributo a lista deve ser ordenada
     String direction // ASC OU DESC
) {
}
