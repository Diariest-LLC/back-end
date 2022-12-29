package com.diariest.server.database;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
@Accessors(chain = true)
public class User {

    @PrimaryKey
    private UUID id;
    private String name;
    private String surname;

}
