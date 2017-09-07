package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Demo get(String name, String email) {
        List<Demo> demoList = this.list();
        Demo demo = null;
        for (Demo singleDemo: demoList) {
            if (Objects.equals(singleDemo.getName(), name) && Objects.equals(singleDemo.getEmail(), email)) {
                Long id = singleDemo.getId();
                demo = this.demoRepository.getOne(id);
            }
        }

        return demo;
    }

    @Override
    public void save(Demo n) {
        this.demoRepository.save(n);
    }

    @Override
    public void delete(String name, String email) {
        Demo demo = this.get(name, email);
        this.demoRepository.delete(demo.getId());
    }

    @Override
    public void update(String name, String email) {
        //TODO: to write whole method
    }
}
