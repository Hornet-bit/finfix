package by.birukov.controller;

import by.birukov.entity.User;
import by.birukov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder bCrypt;

    @Autowired
    private UserService userService;

    @PostMapping("/sing-up")
    public void singUp(@RequestBody User user){
//        user.setPassword(bCrypt.encode(user.getPassword()));
        String encodedPassword = bCrypt.encode("abc");
        System.out.println(encodedPassword);
//        userService.save(user);
    }



}
