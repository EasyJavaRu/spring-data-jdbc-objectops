package ru.easyjava.spring.data.jdbc.dao;

import ru.easyjava.spring.data.jdbc.entity.Order;

/**
 * Order database layer.
 */
public interface OrderRepository {
    /**
     * Loads order from the database by it's id.
     * @param id id of order to load.
     * @return Loaded object or null.
     */
    Order get(Integer id);

}
