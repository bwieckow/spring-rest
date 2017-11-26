package com.example.demo;

import java.util.List;

interface UserService {
    //UserRepository demoRepository = null;
    List<User> list();

    void save(User n);

    //void delete(User n);

    User get(String name, String email);

    User get(String name);

    void delete(String name, String email);

    void delete(User user);

    void update(String name, String email, String newName, String newEmail);
}
