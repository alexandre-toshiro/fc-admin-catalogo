package com.fullcycle.admin.catalogo.infrastructure.category.presenters;

import com.fullcycle.admin.catalogo.application.category.retrieve.get.CategoryOutput;
import com.fullcycle.admin.catalogo.infrastructure.category.models.CategoryApiOutput;

import java.util.function.Function;

public interface CategoryApiPresenter {

//    Function<CategoryOutput, CategoryApiOutput> present = uma outra forma
//            outPut -> new CategoryApiOutput(
//                    outPut.id().getValue(),
//                    outPut.name(),
//                    outPut.description(),
//                    outPut.isActive(),
//                    outPut.createdAt(),
//                    outPut.updatedAt(),
//                    outPut.deletedAt()
//            );


    static CategoryApiOutput present(final CategoryOutput outPut) {
        return new CategoryApiOutput(
                outPut.id().getValue(),
                outPut.name(),
                outPut.description(),
                outPut.isActive(),
                outPut.createdAt(),
                outPut.updatedAt(),
                outPut.deletedAt()
        );
    }
}
