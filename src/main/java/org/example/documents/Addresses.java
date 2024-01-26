package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
public class Addresses {
    String idAddresses;
    String street;
    String n_department;
    String district;
    String city;

    public Document toDocument()
    {
        Document document = new Document();
        document.append("street",this.street);
        document.append("n_department",this.n_department);
        document.append("district",this.district);
        document.append("city",this.city);
        return document;
    }

}
