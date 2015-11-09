package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class OrderEntity implements IEntity<Integer> {
    private int id;
    private int productSizeColorEntity;

    @Override
    public Integer getId() {
        return this.id;
    }

    public int getProductSizeColorEntity() {
        return this.productSizeColorEntity;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setProductSizeColorEntity(int value) {
        this.productSizeColorEntity = value;
    }
}
