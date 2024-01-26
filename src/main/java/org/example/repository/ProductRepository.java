package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.documents.Products;

import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private static MongoCollection collectionProducts;

    public ProductRepository(MongoCollection collectionProducts)
    {
        this.collectionProducts = collectionProducts;
    }

    public void addProduct(Products product)
    {
        Document documentProduct = product.toDocument();
        collectionProducts.insertOne(documentProduct);
    }

    public static Products findProduct(String productName)
    {
        Document filter = new Document("product_name",productName);
        Document productBD = (Document) collectionProducts.find(filter).first();
        if (productBD != null) {
            return mapDocumentToProducts(productBD);
        } else {
            return null; // O manejar el caso en que no se encuentre el producto
        }
    }
    private static Products mapDocumentToProducts(Document document) {
        Products product = new Products();
        product.setIdProduct(document.getObjectId("_id").toString());
        product.setProduct_name(document.getString("product_name"));
        product.setPrice(document.getDouble("price"));

        // Mapear los comentarios si es necesario
        List<ObjectId> commentsStrings = document.getList("comments",ObjectId.class);
        if (commentsStrings != null) {
            product.setComments(commentsStrings);
        }

        return product;
    }


}
