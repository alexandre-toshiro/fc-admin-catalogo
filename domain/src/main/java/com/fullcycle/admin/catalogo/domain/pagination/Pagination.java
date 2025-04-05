package com.fullcycle.admin.catalogo.domain.pagination;

import java.util.List;

public record Pagination<T>(
        int currentPage, //Pagina atual
        int perPage, // quantas infos por pagina
        long total, // quantas infos no BD
        List<T> items // os itens em si no retorno do BD
) {
}
