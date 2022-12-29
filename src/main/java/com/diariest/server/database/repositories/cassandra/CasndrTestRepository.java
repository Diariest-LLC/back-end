package com.diariest.server.database.repositories.cassandra;

import com.diariest.server.database.models.cassandra.csndrtest;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CasndrTestRepository extends CassandraRepository<csndrtest, UUID> {

}
