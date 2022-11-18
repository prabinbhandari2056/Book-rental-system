package com.example.bookrentalsystem.security;
import com.example.bookrentalsystem.mapper.UserDetailMapper;
import com.example.bookrentalsystem.model.User;
import com.example.bookrentalsystem.repository.user.UserRepository;
import com.example.bookrentalsystem.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserDetailMapper userDetailMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Logger log= LoggerFactory.getLogger(this.getClass());
        MyUserDetails userDetails=new MyUserDetails();
        User user=  userRepo.findUserByUserName(userName);
        if (user!=null){
            userDetails.setUser(user);
        }
        else {
            throw new RuntimeException("Provided user does not exist");
        }
        return  userDetails;
    }

}