package com.diariest.server.database.postgre.services;

import com.diariest.server.database.postgre.models.User;
import com.diariest.server.database.postgre.repositories.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUserId(String userId) {
        Optional<User> userOptional = userRepository.findUserByUserId(userId);
        return userOptional.orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
