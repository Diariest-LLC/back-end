package com.diariest.server.database.services.postgre;

import com.diariest.server.database.models.postgre.User;
import com.diariest.server.database.repositories.postgre.UserRepository;
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

    public void saveAccount(User user) {
        userRepository.save(user);
    }

}
