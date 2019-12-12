package com.example.configuration;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jooq.ConnectionProvider;
import org.jooq.exception.DataAccessException;
import play.Logger;
import play.db.Database;

import java.sql.Connection;
import java.sql.SQLException;

@Singleton
public class PlayConnectionProvider implements ConnectionProvider {

    private Connection connection;

    @Inject
    private Database db;

    Logger.ALogger logger = Logger.of(this.getClass());

    @Override
    public Connection acquire() throws DataAccessException {
        if (connection == null) {
            connection = db.getConnection();
        }
        return connection;
    }

    @Override
    public void release(Connection released) throws DataAccessException {
        if (this.connection != released) {
            throw new IllegalArgumentException("Expected " + this.connection + " but got " + released);
        }
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            logger.error("Error closing connection " + connection, e);
        }
    }
}
