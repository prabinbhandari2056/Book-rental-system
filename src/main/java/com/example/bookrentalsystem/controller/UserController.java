package com.example.bookrentalsystem.controller;

import com.example.bookrentalsystem.pojo.api.ApiResponse;
import com.example.bookrentalsystem.pojo.api.BaseController;
import com.example.bookrentalsystem.pojo.member.MemberDetailRequestPojo;
import com.example.bookrentalsystem.pojo.user.UserDetailRequestPojo;
import com.example.bookrentalsystem.service.member.MemberService;
import com.example.bookrentalsystem.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bookrent/user")
public class UserController extends BaseController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ApiResponse getUser() {
        return success(get("data.get","User"),userService.getUser());
    }

    @PostMapping()
    public ApiResponse saveUser(@RequestBody @Valid UserDetailRequestPojo userDetailRequestPojo){
        userService.saveUserDetails(userDetailRequestPojo);
        return success(get("data.save","User"), null);
    }

    @GetMapping("/{userid}")
    public ApiResponse getUserById(@PathVariable(name = "userid") Integer userId) {
        return success(get("data.get","User"), userService.getUserByUserId(userId));
    }
}
