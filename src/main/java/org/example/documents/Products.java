package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Products {
    String idProduct;
    String product_name;
    Double price;
    List<ObjectId>comments;

    public Document toDocument()
    {
        Document document = new Document();
        document.append("product_name",this.product_name);
        document.append("price",this.price);
        document.append("comments",this.comments);
        return document;
    }
}