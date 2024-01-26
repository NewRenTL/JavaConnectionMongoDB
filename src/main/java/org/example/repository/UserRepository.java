package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.documents.Users;

import java.util.ArrayList;

public class UserRepository {
    MongoCollection collectionUsers;

    public UserRepository(MongoCollection collectionUsers)
    {
        this.collectionUsers = collectionUsers;
    }

    public void addUser(Users user)
    {
        Document document = user.toDocument();
        collectionUsers.insertOne(document);
    }

    public void addProductUser(ObjectId idUser,ObjectId productId)
    {

    }
}
