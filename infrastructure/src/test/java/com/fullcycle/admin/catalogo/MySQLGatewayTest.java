package com.fullcycle.admin.catalogo;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.*;
import java.util.Collection;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ActiveProfiles("test")
@DataJpaTest //Carrega apenas os repositorios @Repository, n enxerha o service....
@ComponentScan(includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".[MySQLGateway]")
})//para resolver, utilizamos esse macete para carregar as classes de gatewayy
@ExtendWith(CleanUpExtension.class) //permite que execute de maneira automatica
public @interface MySQLGatewayTest {
    /**
     * Garante que, antes de cada teste, todas as entidades persistidas sejam apagadas dos repositórios.
     * Isso mantém o isolamento dos testes e evita dependências entre eles.
     */
}
