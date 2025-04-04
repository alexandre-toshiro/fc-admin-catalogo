package com.fullcycle.admin.catalogo.domain;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.util.Objects;

// qualquer classe que extenda de Identifier
public abstract class Entity<ID extends Identifier> {

    protected final ID id;

    protected Entity(final ID id) {
        Objects.requireNonNull(id,"'id' cannot be null");
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public abstract void validate(ValidationHandler handler);

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
