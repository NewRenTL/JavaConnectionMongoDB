package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.documents.Comments;

import org.bson.Document;
import org.example.documents.Products;

import javax.xml.stream.events.Comment;

public class CommentRepository {

    private static MongoCollection collectionComments;

    public CommentRepository(MongoCollection collectionComments)
    {
        this.collectionComments = collectionComments;
    }

    public void addComment(Comments comment)
    {
        Document documentComment = new Document();
        documentComment.append("content",comment.getContent());
        collectionComments.insertOne(documentComment);
    };

    public static Comments findCommentById(ObjectId id)
    {
        Document filter = new Document("_id",id);
        Document result = (Document) collectionComments.find(filter).first();
        if(result != null)
        {
            return mapDocumentToComment(result);
        }
        else
        {
            return null;
        }
    }

    private static Comments mapDocumentToComment(Document document)
    {
        Comments comment = new Comments();
        ObjectId objectId = document.getObjectId("_id");

        comment.setContent(document.getString("content"));
        comment.setId(objectId.toString());
        return comment;
    }

}
