package splitwise.hu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import splitwise.hu.service.UserService;
import splitwise.hu.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private List<User> allUsers= new ArrayList<User>(Arrays.asList(
            new User(1, "Aayush", "aayush@aaaa.com","12345", 123456789),
            new User(2, "Varshney", "aayush@aaaa.com","12345", 123456789),
            new User(3, "hey", "aayush@aaaa.com","12345", 123456789),
            new User(4, "hello", "aayush@aaaa.com","12345", 123456789),
            new User(5, "hi", "aayush@aaaa.com","12345", 123456789)
    ));

    @Autowired
    UserService userService;

//    @RequestMapping("/hello")
//    public String hi() {
//        return "hiaaayush";
//    }

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        List<User> allUser = this.userService.getAllUsers();
        System.out.println(allUser);
        return allUser;
    }

    @RequestMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user", method= RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/user/{id}", method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
