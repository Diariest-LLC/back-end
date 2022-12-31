package com.diariest.server.database.cassandra.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Table
public class Post {

    @PrimaryKey
    private UUID id;
    @Column("post_id")
    private String postId;
    @Column("diary_id")
    private String diaryId;
    @Column("diarist_id")
    private String diaristId;
    @Column("post_type")
    private int postType;
    @Column("posted_date")
    private Date postedDate;
    private String title;
    private String description;
    private String content;

}
