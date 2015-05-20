package ssd.comedyvenue.util;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ConnectionProvider {

    // jdbc:h2:~/data/test
    private static final String databaseUrl = "jdbc:h2:mem:test";

    //Provides a connection to the specified database
    public static ConnectionSource getConnection() throws Exception{

        ConnectionSource connection = new JdbcConnectionSource(databaseUrl);
        return connection;

    }
}
