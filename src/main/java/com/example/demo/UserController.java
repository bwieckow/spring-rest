package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping(path = "/get")
    public
    @ResponseBody
    User getSingleUser(@RequestParam String name,
                       @RequestParam String email) {
        // This returns a JSON or XML with the users
        return userService.get(name, email);
    }

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public
    @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userService.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public
    @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.list();
    }

    @GetMapping(path = "/delete")
    public
    @ResponseBody
    String deleteUser(@RequestParam String name
            , @RequestParam String email) {
        this.userService.delete(name, email);

        return "Deleted";
    }

    @GetMapping(path = "/update")
    public
    @ResponseBody
    String updateUser(@RequestParam String name,
                      @RequestParam String email,
                      @RequestParam String newName,
                      @RequestParam String newEmail) {
        this.userService.update(name, email, newName, newEmail);

        return "Updated";
    }
}
