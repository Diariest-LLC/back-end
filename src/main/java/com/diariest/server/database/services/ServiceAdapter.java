package com.diariest.server.database.services;

import com.diariest.server.database.services.cassandra.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ServiceAdapter {

    @Autowired
    private UserService userService;

}
