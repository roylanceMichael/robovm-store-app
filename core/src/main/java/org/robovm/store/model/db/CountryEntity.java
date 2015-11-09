package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class CountryEntity implements IEntity<Integer> {
    private int id;
    private String name;
    private String code;
    private String state;

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setCode(String value) {
        this.code = value;
    }

    public void setState(String value) {
        this.state = value;
    }
}
