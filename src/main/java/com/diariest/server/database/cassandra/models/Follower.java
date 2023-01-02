package com.diariest.server.database.cassandra.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Table
public class Follower {

    @PrimaryKey
    private UUID id;
    @Column("follower_id")
    private String followerId;
    @Column("following_id")
    private String followingId;
    @Column("following_type")
    private int followingType;
    @Column("followed_date")
    private Date followedDate;

}
