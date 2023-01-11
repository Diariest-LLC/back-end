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

    public User getUserByNickName(String nickName) {
        Optional<User> userOptional = userRepository.findUserByNickName(nickName);
        return userOptional.orElse(null);
    }

    public User getUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        return userOptional.orElse(null);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        Optional<User> userOptional = userRepository.findUserByPhoneNumber(phoneNumber);
        return userOptional.orElse(null);
    }

    public boolean existsUserByNickName(String nickName) {
        return userRepository.existsUserByNickName(nickName);
    }

    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    public boolean existsUserByPhoneNumber(String phoneNumber) {
        return userRepository.existsUserByPhoneNumber(phoneNumber);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
