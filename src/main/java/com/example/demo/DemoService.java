package com.example.demo;

import java.util.List;
import java.util.Optional;

interface DemoService {
    //DemoRepository demoRepository = null;
    List<Demo> list();

    void save(Demo n);

    //void delete(Demo n);

    Demo get(String name, String email);

    Demo get(String name);

    void delete(String name, String email);

    void delete(Demo demo);

    void update(String name, String email, String newName, String newEmail);
}
