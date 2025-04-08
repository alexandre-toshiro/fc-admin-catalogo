package com.fullcycle.admin.catalogo.domain.pagination;

import java.util.List;
import java.util.function.Function;

public record Pagination<T>(
        int currentPage, //Pagina atual
        int perPage, // quantas infos por pagina
        long total, // quantas infos no BD
        List<T> items // os itens em si no retorno do BD
) {
    public <R> Pagination<R> map(final Function<T, R> mapper) {
        List<R> aNewList = this.items.stream()
                .map(mapper)
                .toList();

        return new Pagination<>(currentPage(), perPage(), total(), aNewList);

    }
}
