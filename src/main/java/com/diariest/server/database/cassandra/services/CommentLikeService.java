package com.diariest.server.database.cassandra.services;

import com.diariest.server.database.cassandra.models.CommentLike;
import com.diariest.server.database.cassandra.repositories.CommentLikeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CommentLikeService {

    @Autowired
    private CommentLikeRepository commentLikeRepository;

    public void saveCommentLike(CommentLike commentLike) {
        commentLikeRepository.save(commentLike);
    }

}
