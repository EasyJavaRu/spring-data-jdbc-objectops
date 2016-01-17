package ru.easyjava.spring.data.jdbc.dao;

import ru.easyjava.spring.data.jdbc.entity.Sku;

/**
 * SKU database layer.
 */
public interface SkuRepository {
    /**
     * Replaces sku's description in database.
     * @param sku SKU modofication object with new description value
     */
    void changeDescription(Sku sku);

    /**
     * Returns description of the SKU with specified id.
     * @param id SKU id value.
     * @return SKU description value.
     */
    String getDescription(final Integer id);
}
