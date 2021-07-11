package xyz.invisraidinq.rocketapi.api.database.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import xyz.invisraidinq.rocketapi.api.database.IDatabase;
import xyz.invisraidinq.rocketapi.api.enums.Severity;
import xyz.invisraidinq.rocketapi.api.utils.BukkitLogger;

import java.util.Collections;

public class RocketMongo implements IDatabase {

    private final String databaseName;
    private final String address;
    private final int port;
    private final boolean authEnabled;
    private final String username;
    private final char[] password;
    private final String authDatabase;

    /**
     * Constructor to instantiate an {@link RocketMongo} class
     *
     * @param databaseName The name of the database
     * @param address The mongodb address
     * @param port The mongodb port
     * @param authEnabled Should mongo authenticate?
     * @param username The username to authenticate with
     * @param password The password to authenticate with
     * @param authDatabase The database to authenticate with
     */
    public RocketMongo(String databaseName, String address, int port, boolean authEnabled, String username, String password, String authDatabase) {
        this.databaseName = databaseName;
        this.address = address;
        this.port = port;
        this.authEnabled = authEnabled;
        this.username = username;
        this.password = password.toCharArray();
        this.authDatabase = authDatabase;
    }

    /**
     * Constructor to instantiate an {@link RocketMongo} class
     *
     * @param databaseName The name of the database
     * @param address The mongodb address
     * @param port The mongodb port
     */
    public RocketMongo(String databaseName, String address, int port) {
        this(databaseName, address, port, false, null, "null", null);
    }

    /**
     * Connect to an {@link MongoDatabase}
     *
     * @return The connected {@link MongoDatabase} database
     */
    @Override
    public MongoDatabase connect() {
        ServerAddress serverAddress = new ServerAddress(this.address, this.port);

        MongoClient mongoClient;
        if (this.authEnabled) {
            mongoClient = new MongoClient(serverAddress, Collections.singletonList(MongoCredential.createCredential(
                    this.username,
                    this.authDatabase,
                    this.password
            )));
        } else {
            mongoClient = new MongoClient(serverAddress);
        }

        return mongoClient.getDatabase(this.databaseName);
    }

    /**
     * Disconnect the database
     */
    @Override
    public void disconnect() {
        BukkitLogger.log(Severity.CRITITAL, "You must save your own documents, RocketMongo can't do it for you!");
    }
}
