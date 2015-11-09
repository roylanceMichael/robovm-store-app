package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class ProductSizeEntity implements IEntity<Integer> {
    private int id;
    private String name;

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }
}
