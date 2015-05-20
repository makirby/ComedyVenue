package ssd.comedyvenue.util;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ConnectionProvider {

    private static final String databaseUrl = "jdbc:h2:mem:test";

    //Provides a connection to the specified database
    public static ConnectionSource getConnection() throws Exception{

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        return connectionSource;

    }
}
