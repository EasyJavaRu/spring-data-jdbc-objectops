package ru.easyjava.spring.data.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.easyjava.spring.data.jdbc.dao.queries.OrderMappingQuery;
import ru.easyjava.spring.data.jdbc.entity.Order;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * JDBC based implementation of OrderRepository.
 */
@Repository
public class OrderRepositoryJdbc implements OrderRepository {
    /**
     * Database connection.
     */
    @Inject
    private JdbcTemplate jdbcTemplate;

    /**
     * 'Get query' object.
     */
    private OrderMappingQuery orderQuery;

    /**
     * Here we prepare our query objects.
     */
    @PostConstruct
    public final void init() {
        orderQuery = new OrderMappingQuery(jdbcTemplate);
    }

    @Override
    public final Order get(final Integer id) {
        return orderQuery.findObject(id);
    }
}
