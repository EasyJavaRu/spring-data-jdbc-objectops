package ru.easyjava.spring.data.jdbc.dao.queries;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import java.sql.Types;

/**
 * Sku description change query.
 */
public class UpdateSkuDescriptionQuery extends SqlUpdate {
    /**
     * Constructor.
     * @param jdbcTemplate database connection.
     */
    public UpdateSkuDescriptionQuery(final JdbcTemplate jdbcTemplate) {
        setDataSource(jdbcTemplate.getDataSource());
        setSql("UPDATE skus SET description = ? WHERE id = ?");
        declareParameter(new SqlParameter("description", Types.VARCHAR));
        declareParameter(new SqlParameter("id", Types.INTEGER));
        compile();
    }
}
