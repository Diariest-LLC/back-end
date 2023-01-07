package com.diariest.server.database.cassandra.services;

import com.diariest.server.database.cassandra.models.Follower;
import com.diariest.server.database.cassandra.repositories.FollowerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    public int getFollowerCountByUserId(String userId) {
        return followerRepository.countFollowerByFollowingId(userId);
    }

    public void saveFollower(Follower follower) {
        followerRepository.save(follower);
    }

}
