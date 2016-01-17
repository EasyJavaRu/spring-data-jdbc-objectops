package ru.easyjava.spring.data.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.easyjava.spring.data.jdbc.entity.Customer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

/**
 * JDBC implementation of CustomerRepository.
 */
@Repository
public class CustomerRepositoryJdbc implements CustomerRepository {
    /**
     * Non-parameterized email retrieval query.
     */
    private static final String ALL_EMAIL_QUERY
            = "SELECT EMAIL FROM CUSTOMERS";

    /**
     * 'Create query' object.
     */
    private SimpleJdbcInsert createCustomer;
    /**
     * Database connection.
     */
    @Inject
    private JdbcTemplate jdbcTemplate;

    /**
     * Here we prepare our query objects.
     */
    @PostConstruct
    public final void init() {
        createCustomer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public final void add(final Customer c) {
        createCustomer.execute(new BeanPropertySqlParameterSource(c));
    }

    @Override
    public final List<String> allEmails() {
        return jdbcTemplate.queryForList(ALL_EMAIL_QUERY, String.class);
    }
}
