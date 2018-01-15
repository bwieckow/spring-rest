package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
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
    User getSingleUser(@RequestParam String name) {
        // This returns a JSON or XML with the users
        //Optional<String> email1Opt = Optional.ofNullable(email);
        return userService.get(name);
    }

    @GetMapping(path = "/all")
    public
    @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.list();
    }

    @RequestMapping(path = "/addJSON", method = RequestMethod.POST) // Map ONLY POST Requests
    public
    @ResponseBody
    String addNewUserJSON(@RequestBody User user) {
        userService.save(user);
        return "JSON SAVED";
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public
    @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email
            , @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userService.save(n);
        return "Saved";
    }

    @PostMapping(path = "/delete")
    public
    @ResponseBody
    String deleteUser(@RequestParam String name
            , @RequestParam String email) {
        this.userService.delete(name, email);

        return "Deleted";
    }

    @PostMapping(path = "/update")
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
