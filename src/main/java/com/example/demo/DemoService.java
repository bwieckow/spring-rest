package com.example.demo;

import java.util.List;

interface DemoService {
    //DemoRepository demoRepository = null;
    List<Demo> list();

    void save(Demo n);

}
