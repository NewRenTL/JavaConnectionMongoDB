package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Users {
    String idUser;
    String name;
    String password;
    List<Products> products;
    List<Addresses> addresses;

    public Document toDocument()
    {
        Document document = new Document();
        document.append("name",this.name);
        document.append("password",this.password);
        document.append("products",this.products);
        document.append("addresses",this.addresses);
        return document;
    }
}
