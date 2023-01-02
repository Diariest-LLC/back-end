package com.diariest.server.database.cassandra.services;

import com.diariest.server.database.cassandra.models.Comment;
import com.diariest.server.database.cassandra.repositories.CommentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

}
