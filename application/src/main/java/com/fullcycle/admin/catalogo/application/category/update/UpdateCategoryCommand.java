package com.fullcycle.admin.catalogo.application.category.update;

public record UpdateCategoryCommand(
        String id,
        String name,
        String description,
        boolean isActive
) {

    public static UpdateCategoryCommand with(
            final String anId,
            final String anName,
            final String aDescription,
            final boolean isActive
    ) {
        return new UpdateCategoryCommand(anId, anName, aDescription, isActive);
    }
}
