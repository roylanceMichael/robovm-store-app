package org.robovm.store.service;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.robovm.store.model.db.*;
import org.roylance.yaorm.models.db.migration.MigrationModel;
import org.roylance.yaorm.services.*;

import java.util.Arrays;

public class StoreContext extends EntityContext {
    private static final String ContextName = "StoreContext";

    private final IEntityService<Integer, CountryEntity> countryService;
    private final IEntityService<Integer, ProductColorEntity> productColorService;
    private final IEntityService<Integer, ProductSizeEntity> productSizeService;
    private final IEntityService<Integer, ProductTypeEntity> productTypeService;
    private final IEntityService<Integer, ProductSizeColorEntity> productSizeColorService;
    private final IEntityService<Integer, ProductEntity> productService;
    private final IEntityService<Integer, OrderEntity> orderService;
    private final IEntityService<Integer, BasketEntity> basketService;

    public StoreContext(
            @NotNull IEntityService<Integer, CountryEntity> countryService,
            @NotNull IEntityService<Integer, ProductColorEntity> productColorService,
            @NotNull IEntityService<Integer, ProductSizeEntity> productSizeService,
            @NotNull IEntityService<Integer, ProductTypeEntity> productTypeService,
            @NotNull IEntityService<Integer, ProductSizeColorEntity> productSizeColorService,
            @NotNull IEntityService<Integer, ProductEntity> productService,
            @NotNull IEntityService<Integer, OrderEntity> orderService,
            @NotNull IEntityService<Integer, BasketEntity> basketService,
            @NotNull IEntityService<Long, MigrationModel> migrationService,
            @NotNull Gson gson) {
        super(Arrays.asList(
                countryService,
                productColorService,
                productSizeService,
                productTypeService,
                productService,
                productSizeColorService,
                orderService,
                basketService),
                migrationService,
                ContextName,
                gson);

        this.countryService = countryService;
        this.productColorService = productColorService;
        this.productSizeService = productSizeService;
        this.productTypeService = productTypeService;
        this.productSizeColorService = productSizeColorService;
        this.productService = productService;
        this.orderService = orderService;
        this.basketService = basketService;
    }

    public IEntityService<Integer, CountryEntity> getCountryService() {
        return this.countryService;
    }

    public IEntityService<Integer, ProductColorEntity> getProductColorService() {
        return this.productColorService;
    }

    public IEntityService<Integer, ProductSizeEntity> getProductSizeService() {
        return this.productSizeService;
    }

    public IEntityService<Integer, ProductTypeEntity> getProductTypeService() {
        return this.productTypeService;
    }

    public IEntityService<Integer, ProductSizeColorEntity> getProductSizeColorService() {
        return this.productSizeColorService;
    }

    public IEntityService<Integer, ProductEntity> getProductService() {
        return this.productService;
    }

    public IEntityService<Integer, OrderEntity> getOrderService() {
        return this.orderService;
    }

    public IEntityService<Integer, BasketEntity> getBasketService() {
        return this.basketService;
    }

    public static StoreContext factory(
            ISqlGeneratorService sqlGeneratorService,
            IGranularDatabaseService granularDatabaseService) {
        final IEntityService<Integer, CountryEntity> countryService = new EntityService(
                CountryEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, ProductColorEntity> productColorService = new EntityService(
                ProductColorEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, ProductSizeEntity> productSizeService = new EntityService(
                ProductSizeEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, ProductTypeEntity> productTypeService = new EntityService(
                ProductTypeEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, ProductSizeColorEntity> productSizeColorService = new EntityService(
                ProductSizeColorEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, ProductEntity> productService = new EntityService(
                ProductEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, OrderEntity> orderService = new EntityService(
                OrderEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Integer, BasketEntity> basketService = new EntityService(
                BasketEntity.class,
                granularDatabaseService,
                sqlGeneratorService, null);
        final IEntityService<Long, MigrationModel> migrationService = new EntityService(
                MigrationModel.class,
                granularDatabaseService,
                sqlGeneratorService, null);


        return new StoreContext(
                countryService,
                productColorService,
                productSizeService,
                productTypeService,
                productSizeColorService,
                productService,
                orderService,
                basketService,
                migrationService,
                new Gson());

    }
}
