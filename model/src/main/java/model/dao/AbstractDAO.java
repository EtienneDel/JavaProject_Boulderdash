package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * The Class AbstractDAO allows to execute queries on the database.
 */
public abstract class AbstractDAO {

    /**
     * Execute query.
     *
     * @param query the query
     * @return the result set
     */
    protected static ResultSet executeQuery(final String query) {
        return BoulderDashBDDConnector.getInstance().executeQuery(query);
    }

    /**
     * Execute update.
     *
     * @param query the query
     * @return the int
     */
    protected static int executeUpdate(final String query) {
        return BoulderDashBDDConnector.getInstance().executeUpdate(query);
    }

    /**
     * Prepare call.
     *
     * @param query the query
     * @return the callable statement
     */
    protected static CallableStatement prepareCall(final String query) {
        return BoulderDashBDDConnector.getInstance().prepareCall(query);
    }
}
