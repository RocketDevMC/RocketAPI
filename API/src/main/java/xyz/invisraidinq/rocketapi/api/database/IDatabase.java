package xyz.invisraidinq.rocketapi.api.database;

public interface IDatabase {

    Object connect();
    void disconnect();
}
