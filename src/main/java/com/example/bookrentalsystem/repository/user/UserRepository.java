package com.example.bookrentalsystem.repository.user;
import com.example.bookrentalsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where user_name = ?1", nativeQuery = true)
    User findUserByUserName(String userName);

    @Query(value = "select * from users order by id desc", nativeQuery = true)
    List<User> getList();

}