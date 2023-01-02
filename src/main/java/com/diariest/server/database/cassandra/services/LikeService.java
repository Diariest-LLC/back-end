package com.diariest.server.database.cassandra.services;

import com.diariest.server.database.cassandra.models.Like;
import com.diariest.server.database.cassandra.repositories.LikeRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public void saveLike(Like like) {
        likeRepository.save(like);
    }

}
