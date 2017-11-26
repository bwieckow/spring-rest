package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User get(String name, String email) {
        List<User> userList = this.list();
        User user = null;
        for (User singleUser : userList) {
            if (Objects.equals(singleUser.getName(), name) && Objects.equals(singleUser.getEmail(), email)) {
                Long id = singleUser.getId();
                user = this.userRepository.getOne(id);
            }
        }

        return user;
    }

    @Override
    public User get(String name) {
        List<User> userList = this.list();
        User user = null;
        for (User singleUser : userList) {
            if (Objects.equals(singleUser.getName(), name)) {
                Long id = singleUser.getId();
                user = this.userRepository.getOne(id);
            }
        }

        return user;
    }

    @Override
    public void save(User n) {
        this.userRepository.save(n);
    }

    @Override
    public void delete(String name, String email) {
        User user = this.get(name, email);
        this.userRepository.delete(user.getId());
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public void update(String name, String email, String newName, String newEmail) {
        User user = this.get(name, email);
        this.userRepository.delete(user);
        user.setName(newName);
        user.setEmail(newEmail);
        user.setId(user.getId());
        System.out.println(user);
        this.userRepository.save(user);
    }
}
