package com.diariest.server.database.cassandra.services;

import com.diariest.server.database.cassandra.models.Post;
import com.diariest.server.database.cassandra.repositories.PostRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class PostService {

    @Autowired
    public PostRepository postRepository;

    //TODO algorithm methods.

    public void savePost(Post post) {
        postRepository.save(post);
    }

}
