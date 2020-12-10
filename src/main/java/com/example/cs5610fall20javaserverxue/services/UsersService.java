package com.example.cs5610fall20javaserverxue.services;

import com.example.cs5610fall20javaserverxue.models.User;
import com.example.cs5610fall20javaserverxue.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<User> findAllUsers() {
        return (List<User>) usersRepository.findAll();
    }


    public User findUserByUsername (String username) {
        return usersRepository.findUserByUsername(username);
    }

    public User createUser(User user) {
        return usersRepository.save(user); //insert
    }

    public User updateUser(Integer userId, User newUser) {
        Optional userO = usersRepository.findById(userId);
        if(userO.isPresent()){
            User user = (User) userO.get();
            user.setPhone(newUser.getPhone());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setDateofbirth(newUser.getDateofbirth());
            user.setAddress(newUser.getAddress());
            return usersRepository.save(user);
        }else {
            return null;
        }
    }

    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }
}

