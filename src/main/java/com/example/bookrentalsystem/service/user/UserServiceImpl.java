package com.example.bookrentalsystem.service.user;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.mapper.UserDetailMapper;
import com.example.bookrentalsystem.model.User;
import com.example.bookrentalsystem.pojo.user.UserDetailRequestPojo;
import com.example.bookrentalsystem.repository.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final UserDetailMapper userDetailMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteUserById(Integer userId) throws AppException {
        Optional<User> exists = userRepo.findById(userId);
        if (!exists.isPresent()) {
            throw new AppException("User does not exist by given " + userId + " User Id");
        } else if (exists.isPresent()) {
            userRepo.deleteById(userId);
        }
    }

    @Override
    public Object getUserByUserId(Integer userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found by given id"));
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepo.findUserByUserName(userName);
    }


    @Override
    public void saveUserDetails(UserDetailRequestPojo userDetailRequestPojo) {
        User user = null;
        if (userDetailRequestPojo.getUserId() != null)
            user = userRepo.findById(userDetailRequestPojo.getUserId()).orElse(new User());
        user = objectMapper.convertValue(userDetailRequestPojo, User.class);
        user.setPassword(passwordEncoder.encode(userDetailRequestPojo.getPassword()));
        userRepo.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepo.findAll();
    }

}
