package dev.blackdev.utils.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBHelper {
    private MongoClient client;
    private MongoDatabase database;

    public void connect(String dbName, String connectionString) {
        client = MongoClients.create(connectionString);
        database = client.getDatabase(dbName);
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        if (client != null)
            client.close();
    }
}
