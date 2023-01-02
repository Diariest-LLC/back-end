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
public class CommentLike {

    @PrimaryKey
    private UUID id;

    @Column("comment_id")
    private String commentId;

    @Column("post_id")
    private String postId;

    @Column("liker_id")
    private String likerId;

    @Column("liked_date")
    private Date likedDate;

}
