package com.fullcycle.admin.catalogo;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;

public class CleanUpExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(final ExtensionContext context) throws Exception {
        Collection<CrudRepository> repositories =
                SpringExtension.getApplicationContext(context)
                        .getBeansOfType(CrudRepository.class)
                        .values();

        cleanUp(repositories);
    }

    private void cleanUp(final Collection<CrudRepository> repositories) {
        repositories.forEach(CrudRepository::deleteAll);
    }

        /*
    Normalmente para este tipo de comportamente se utiliza o @BeforeEach, mas é muito comum os devs esquecerem
    Para garantir que isto não aconteça, fazemos estas configurações que já faz isso de maneira automática.
    Basta anotar todas as classes de teste de gateway de banco com esta annotation
     */
}
