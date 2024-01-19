package org.example;

import org.example.db.MongoDBConnector;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoDBConnector.connect();
        List<String> collections = MongoDBConnector.database.listCollectionNames().into(new ArrayList<>());
    }
}