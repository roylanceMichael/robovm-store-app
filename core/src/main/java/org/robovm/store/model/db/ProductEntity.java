package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class ProductEntity implements IEntity<Integer> {
    private int id;
    private String name;
    private String description;
    private double price;
    private int productTypeId;

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getProductTypeId() {
        return this.productTypeId;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public void setPrice(double value) {
        this.price = value;
    }

    public void setProductTypeId(int value) {
        this.productTypeId = value;
    }
}
