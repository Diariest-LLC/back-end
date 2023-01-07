package com.diariest.server.database.cassandra.repositories;

import com.diariest.server.database.cassandra.models.Follower;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FollowerRepository extends CassandraRepository<Follower, UUID> {

    int countFollowerByFollowingId(String followingId);

}
