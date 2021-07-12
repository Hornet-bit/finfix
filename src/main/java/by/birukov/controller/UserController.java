package by.birukov.controller;

import by.birukov.dto.UserPreferences;
import by.birukov.entity.Fandom;
import by.birukov.entity.User;
import by.birukov.service.FandomsService;
import by.birukov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder bCrypt;

    @Autowired
    private UserService userService;

    @Autowired
    private FandomsService fandomsService;

    //    @CrossOrigin(origins = "*", allowedHeaders = "*", originPatterns = "*")
    @PostMapping("/sing-up")
    public void singUp(@RequestBody User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        userService.save(user);

        String encodedPassword = bCrypt.encode(user.getPassword());
        System.out.println(encodedPassword);
    }

    @PostMapping("/get-info")
    public User getInfo(@RequestBody User user) {
        return userService.getUserByUsername(user.getUsername());
    }

    @PostMapping("/update-user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PostMapping("/set-pref")
    public void setFandoms(@RequestBody UserPreferences user) {
        User userFromDb = userService.getUserByUsername(user.getUsername());



        System.out.println("all pref \n" + user.getFandoms().toString());
        List<Fandom> fandoms = fandomsService.getUserFandoms(user.getFandoms());

        userFromDb.setFandoms(fandoms);

        userService.setPreferences(userFromDb);

//        userService.setPreferences(userFromDb);
//        userService.updateUser(user);
    }


}
