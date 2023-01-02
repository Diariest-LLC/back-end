package com.diariest.server.database.cassandra.repositories;

import com.diariest.server.database.cassandra.models.CommentLike;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentLikeRepository extends CassandraRepository<CommentLike, UUID> {
}
