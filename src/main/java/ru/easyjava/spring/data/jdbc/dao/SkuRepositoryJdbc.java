package ru.easyjava.spring.data.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.easyjava.spring.data.jdbc.dao.queries.UpdateSkuDescriptionQuery;
import ru.easyjava.spring.data.jdbc.entity.Sku;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Collections;

/**
 * JDBC based implementation of the SKU repository.
 */
@Repository
public class SkuRepositoryJdbc implements SkuRepository {
    /**
     * Query for description retrieval.
     */
    private static final String DESCRIPTION_QUERY
            = "SELECT DESCRIPTION FROM SKUS WHERE ID = :id";

    /**
     * 'Update description query' object.
     */
    private UpdateSkuDescriptionQuery updateQuery;

    /**
     * Database object.
     */
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * We need simple JdbcTemplate to be able
     * to extract DataSource from it.
     */
    @Inject
    private JdbcTemplate simpleJdbcTemplate;

    /**
     * Here we prepare our query objects.
     */
    @PostConstruct
    public final void init() {
        updateQuery = new UpdateSkuDescriptionQuery(simpleJdbcTemplate);
    }

    @Override
    public final void changeDescription(final Sku sku) {
        updateQuery.update(sku.getDescription(), sku.getId());
    }

    @Override
    public final String getDescription(final Integer id) {
        return jdbcTemplate.queryForObject(
                DESCRIPTION_QUERY,
                Collections.singletonMap("id", id),
                String.class);
    }
}
