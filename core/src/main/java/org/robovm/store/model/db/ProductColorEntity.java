package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class ProductColorEntity implements IEntity<Integer> {
    private int id;
    private String name;
    private String url;

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setUrl(String value) {
        this.url = value;
    }
}
