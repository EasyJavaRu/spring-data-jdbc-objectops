package ru.easyjava.spring.data.jdbc.dao.queries;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.easyjava.spring.data.jdbc.entity.Customer;
import ru.easyjava.spring.data.jdbc.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Predefined query that extracts orders by id.
 */
public class OrderMappingQuery extends MappingSqlQuery<Order> {
    /**
     * Query for specific order.
     */
    private static final String ORDER_QUERY
            = "SELECT O.ID, CUSTOMER_ID, EMAIL "
            + "FROM ORDERS AS O, CUSTOMERS AS C "
            + "WHERE C.ID=O.CUSTOMER_ID AND O.ID=?";

    /**
     * Mandatory constructor.
     * @param jdbcTemplate database connection.
     */
    public OrderMappingQuery(final JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate.getDataSource(), ORDER_QUERY);
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
        compile();
    }

    @Override
    protected final Order mapRow(
            final ResultSet resultSet,
            final int rowNum)
            throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("customer_id"));
        customer.setEmail(resultSet.getString("email"));

        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setCustomer(customer);

        return order;
    }
}
