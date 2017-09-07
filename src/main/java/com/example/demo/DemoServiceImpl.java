package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    private DemoRepository demoRepository;

    @Autowired
    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public List<Demo> list() {
        return demoRepository.findAll();
    }

    @Override
    public void save(Demo n) {
        this.demoRepository.save(n);
    }

    @Override
    public void delete(Demo n) {
        this.demoRepository.delete(n.getId());
    }

    @Override
    public Demo get(String name, String email) {
        List<Demo> demoList = this.list();
        Demo demo = null;
        for (Demo singleDemo: demoList) {
           if (singleDemo.getName() == name && singleDemo.getEmail() == email) {
               demo = this.demoRepository.getOne(singleDemo.getId());
           }
        }
        return demo;
    }
}
