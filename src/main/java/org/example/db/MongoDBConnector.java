package org.example.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;

public class MongoDBConnector {

    private MongoClient mongoClient;
    @Getter
    private MongoDatabase database;

    public MongoDBConnector(String connectionString, String databaseName) {
        this.mongoClient = MongoClients.create(connectionString);

        this.database = mongoClient.getDatabase(databaseName);
    }
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
