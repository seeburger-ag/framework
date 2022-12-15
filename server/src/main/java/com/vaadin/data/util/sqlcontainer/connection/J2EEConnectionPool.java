/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class J2EEConnectionPool implements JDBCConnectionPool {

    private String dataSourceJndiName;

    private DataSource dataSource = null;

    public J2EEConnectionPool(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public J2EEConnectionPool(String dataSourceJndiName) {
        this.dataSourceJndiName = dataSourceJndiName;
    }

    @Override
    public Connection reserveConnection() throws SQLException {
        Connection conn = getDataSource().getConnection();
        conn.setAutoCommit(false);

        return conn;
    }

    private DataSource getDataSource() throws SQLException {
        if (dataSource == null) {
            dataSource = lookupDataSource();
        }
        return dataSource;
    }

    private DataSource lookupDataSource() throws SQLException {
        try {
            InitialContext ic = new InitialContext();
            return (DataSource) ic.lookup(dataSourceJndiName);
        } catch (NamingException e) {
            throw new SQLException(
                    "NamingException - Cannot connect to the database. Cause: "
                            + e.getMessage());
        }
    }

    @Override
    public void releaseConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(J2EEConnectionPool.class.getName())
                        .log(Level.FINE, "Could not release SQL connection", e);
            }
        }
    }

    @Override
    public void destroy() {
        dataSource = null;
    }

}
