package org.example.service;

import org.example.documents.Comments;
import org.example.repository.CommentRepository;

public class CommentService {
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comments comment)
    {
        //Check information or Business Logic
        try {
            commentRepository.addComment(comment);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
