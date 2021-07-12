package by.birukov.service;

import by.birukov.entity.User;

public interface UserService {
    User save(User user);

    User getUserByUsername(String username);

    void updateUser(User user);

    void setPreferences(User user);
}
