package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.db.MongoDBConnector;
import org.example.documents.Comments;
import org.example.documents.Products;
import org.example.documents.Users;
import org.example.repository.CommentRepository;
import org.example.repository.ProductRepository;
import org.example.repository.UserRepository;
import org.example.service.CommentService;
import org.example.service.ProductService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MongoDBConnector.connect();
        List<String> collections = MongoDBConnector.database.listCollectionNames().into(new ArrayList<>());
        MongoCollection commentsCollection = MongoDBConnector.database.getCollection("comments");
        MongoCollection productsCollection = MongoDBConnector.database.getCollection("products");
        MongoCollection usersCollection = MongoDBConnector.database.getCollection("users2");


        CommentRepository commentRepository = new CommentRepository(commentsCollection);
        CommentService commentService = new CommentService(commentRepository);

        ProductRepository productRepository = new ProductRepository(productsCollection);
        ProductService productService = new ProductService(productRepository);

        UserRepository userRepository = new UserRepository(usersCollection);
        UserService userService = new UserService(userRepository);

        /*
        Users user1 = new Users();
        user1.setName("Sierpe");
        user1.setPassword("sierpe_123");
        user1.setProducts(new ArrayList<>());
        user1.setAddresses(new ArrayList<>());
        userService.addUser(user1);
        */
        Products extractedProduct  = ProductRepository.findProduct("Laptop HP");
        if(extractedProduct != null)
        {
            //System.out.println("yes");
            List<ObjectId> commentsId = extractedProduct.getComments();
            for (ObjectId commentId:commentsId)
            {
                System.out.println(commentId);
            }
        }
        else{
            System.out.println("not");
        }

        List<ObjectId> commentsIds = extractedProduct.getComments();
        for(ObjectId commentId:commentsIds)
        {
            Comments commentX = commentRepository.findCommentById(commentId);
            if(commentX!= null)
            {
                System.out.println(commentX.getId());
                System.out.println(commentX.getContent());
            }
        }

        /*
        Products product1 = new Products();
        product1.setProduct_name("Laptop OMEN");
        product1.setPrice(2100.99);
        product1.setComments(new ArrayList<>());
        productService.addProduct(product1);
        */

        /*
        Comments comment = new Comments();
        comment.setContent("This product is nice");
        commentService.addComment(comment);
        */

    }
}