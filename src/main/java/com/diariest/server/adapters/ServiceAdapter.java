package com.diariest.server.adapters;

import com.diariest.server.database.cassandra.repositories.CommentLikeRepository;
import com.diariest.server.database.cassandra.repositories.CommentRepository;
import com.diariest.server.database.cassandra.repositories.LikeRepository;
import com.diariest.server.database.cassandra.services.FollowerService;
import com.diariest.server.database.cassandra.services.PostService;
import com.diariest.server.database.postgre.services.DiaryService;
import com.diariest.server.database.postgre.services.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ServiceAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private PostService postService;

    @Autowired
    private FollowerService followerService;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentLikeRepository commentLikeRepository;

}
