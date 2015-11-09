package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class BasketEntity implements IEntity<Integer> {
    private int id;
    private String name;
    private int orderId;

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getOrderId() {
        return this.orderId;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setOrderId(int value) {
        this.orderId = value;
    }
}
