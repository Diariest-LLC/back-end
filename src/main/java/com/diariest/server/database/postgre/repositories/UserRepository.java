package com.diariest.server.database.postgre.repositories;

import com.diariest.server.database.postgre.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserId(String userId);

    Optional<User> findUserByNickName(String nickName);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByPhoneNumber(String phoneNumber);

    boolean existsUserByNickName(String nickName);

    boolean existsUserByEmail(String email);

    boolean existsUserByPhoneNumber(String phoneNumber);


}
