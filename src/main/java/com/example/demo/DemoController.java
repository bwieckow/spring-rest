package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.io.Console;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    ResponseEntity<List<Demo>> list() {
        return ResponseEntity.ok(demoService.list());
    }

    @GetMapping(path = "/get")
    public
    @ResponseBody
    Demo getSingleUser(@RequestParam String name,
                       @RequestParam String email) {
        // This returns a JSON or XML with the users
        return demoService.get(name, email);
    }

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public
    @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Demo n = new Demo();
        n.setName(name);
        n.setEmail(email);
        demoService.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public
    @ResponseBody
    Iterable<Demo> getAllUsers() {
        // This returns a JSON or XML with the users
        return demoService.list();
    }

    @GetMapping(path = "/delete")
    public
    @ResponseBody
    String deleteUser(@RequestParam String name
            , @RequestParam String email) {
        //Demo demo = this.getSingleUser(name, email);
        this.demoService.delete(name, email);

        return "Deleted";
    }

    @GetMapping(path = "/update")
    public
    @ResponseBody
    String updateUser(@RequestParam String name,
                      @RequestParam String email,
                      @RequestParam String newName,
                      @RequestParam String newEmail) {
        //TODO: To write whole method
        this.demoService.update(name, email, newName, newEmail);

        return "Updated";
    }
}
