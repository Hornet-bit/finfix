package by.birukov.security.services;

import by.birukov.entity.MyUserDetails;
import by.birukov.entity.User;
import by.birukov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.EMPTY_LIST;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    //todo возможно нужно автовайрить сервисы

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }

//        return new MyUserDetails(user);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword()
                ,EMPTY_LIST);
    }
}
