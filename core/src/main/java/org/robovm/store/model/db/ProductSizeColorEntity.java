package org.robovm.store.model.db;

import org.roylance.yaorm.models.IEntity;

public class ProductSizeColorEntity implements IEntity<Integer> {
    private int id;
    private int productId;
    private int productSizeId;
    private int productColorId;

    @Override
    public Integer getId() {
        return this.id;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getProductSizeId() {
        return this.productSizeId;
    }

    public int getProductColorId() {
        return this.productColorId;
    }

    @Override
    public void setId(Integer value) {
        this.id = value;
    }

    public void setProductId(int value) {
        this.productId = value;
    }

    public void setProductSizeId(int value) {
        this.productSizeId = value;
    }

    public void setProductColorId(int value) {
        this.productColorId = value;
    }
}
