package by.birukov.service.impl;

import by.birukov.entity.User;
import by.birukov.repository.UserRepository;
import by.birukov.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        userFromDb.setAvatar(user.getAvatar());
        userRepository.save(userFromDb);

        System.out.println(user.getAvatar());
    }

    @Override
    public void setPreferences(User user) {
        userRepository.save(user);
    }

}
