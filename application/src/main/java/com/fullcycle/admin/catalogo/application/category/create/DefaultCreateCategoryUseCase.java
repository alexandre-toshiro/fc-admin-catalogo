package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.category.Category;
import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand aCommand) {
        final var aName = aCommand.name();
        final var aDescription = aCommand.description();
        final var isActive = aCommand.isActive();

        final var notification = Notification.create();

        final var aCategory = Category.newCategory(aName, aDescription, isActive);
        aCategory.validate(notification);

        return notification.hasErrors() ? API.Left(notification) : create(aCategory);
        //API.Left(notification) -> possivel erro de validação
    }

    private Either<Notification, CreateCategoryOutput> create(final Category aCategory) {

        //try mais funcional e mais legivel - varvr
        return API.Try(() -> this.categoryGateway.create(aCategory))
                .toEither()
                // converte para um either<Throwble, Objeto>(no caso de category)
                .bimap(Notification::create, CreateCategoryOutput::from);

    }

    /*
     * O `bimap` substitui `map(CreateCategoryOutput::from).mapLeft(Notification::create)`, como o próprio nome sugere.
     * Como ele mapeia para um `Throwable`, foi necessário criar um método auxiliar na classe `Notification`
     * para permitir o uso de `Notification::create`.
     *
     * Aqui, estamos tratando possíveis erros com `Try` e retornando um `Notification` caso ocorra uma falha
     * ao tentar persistir no banco de dados.
     */
}
