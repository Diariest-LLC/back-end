package com.diariest.server.database.services.cassandra;

import com.diariest.server.database.User;
import com.diariest.server.database.repositories.cassandra.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserService {

    @Autowired
    public UserRepository userRepository;

    //TODO algorithm methods.

    public void saveAccount(User user) {
        userRepository.save(user);
    }

}
