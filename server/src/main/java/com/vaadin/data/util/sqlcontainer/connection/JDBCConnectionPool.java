/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for implementing connection pools to be used with SQLContainer.
 */
public interface JDBCConnectionPool extends Serializable {
    /**
     * Retrieves a connection.
     *
     * @return a usable connection to the database
     * @throws SQLException
     */
    public Connection reserveConnection() throws SQLException;

    /**
     * Releases a connection that was retrieved earlier.
     *
     * Note that depending on implementation, the transaction possibly open in
     * the connection may or may not be rolled back.
     *
     * @param conn
     *            Connection to be released
     */
    public void releaseConnection(Connection conn);

    /**
     * Destroys the connection pool: close() is called an all the connections in
     * the pool, whether available or reserved.
     *
     * This method was added to fix PostgreSQL -related issues with connections
     * that were left hanging 'idle'.
     */
    public void destroy();
}
