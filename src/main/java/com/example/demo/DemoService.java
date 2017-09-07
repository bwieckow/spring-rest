package com.example.demo;

import java.util.List;

interface DemoService {
    //DemoRepository demoRepository = null;
    List<Demo> list();

    void save(Demo n);

    //void delete(Demo n);

    Demo get(String name, String email);

    void delete(String name, String email);

    void update(String name, String email);
}
