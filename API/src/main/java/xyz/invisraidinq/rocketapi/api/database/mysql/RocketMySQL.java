package xyz.invisraidinq.rocketapi.api.database.mysql;

import xyz.invisraidinq.rocketapi.api.database.IDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RocketMySQL implements IDatabase {

    private final String host;
    private final int port;
    private final String database;
    private final boolean useSsl;
    private final String username;
    private final String password;

    private Connection connection;

    /**
     * Instantiate an {@link RocketMySQL} class
     *
     * @param host The sql host
     * @param port The sql port
     * @param database The sql database
     * @param useSsl Should SSL be used
     * @param username The username
     * @param password The password
     */
    public RocketMySQL(String host, int port, String database, boolean useSsl, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.useSsl = useSsl;
        this.username = username;
        this.password = password;
    }

    /**
     * Connect to the mysql database
     *
     * @return A connected {@link Connection}
     */
    @Override
    public Connection connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" +
                    this.database + "?useSSL=" + this.useSsl, this.username, this.password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.connection;
    }

    /**
     * Disconnect from the database
     */
    @Override
    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isConnected() {
        return this.connection != null;
    }
}
