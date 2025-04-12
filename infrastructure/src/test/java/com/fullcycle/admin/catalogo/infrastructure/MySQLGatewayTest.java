package com.fullcycle.admin.catalogo.infrastructure;

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
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*[MySQLGateway]")
})//para resolver, utilizamos esse macete para carregar as classes de gatewayy
@ExtendWith(MySQLGatewayTest.CleanUpExtension.class) //permite que execute de maneira automatica
public @interface MySQLGatewayTest {
    /**
     * Garante que, antes de cada teste, todas as entidades persistidas sejam apagadas dos repositórios.
     * Isso mantém o isolamento dos testes e evita dependências entre eles.
     */

    class CleanUpExtension implements BeforeEachCallback {

        @Override
        public void beforeEach(final ExtensionContext context) throws Exception {
            Collection<CrudRepository> repositories =
                    SpringExtension.getApplicationContext(context)
                            .getBeansOfType(CrudRepository.class)
                            .values();
        }

        private void cleanUp(final Collection<CrudRepository> repositories) {
            repositories.forEach(CrudRepository::deleteAll);
        }
    }
    /*
    Normalmente para este tipo de comportamente se utiliza o @BeforeEach, mas é muito comum os devs esquecerem
    Para garantir que isto não aconteça, fazemos estas configurações que já faz isso de maneira automática.
    Basta anotar todas as classes de teste de gateway de banco com esta annotation
     */
}
