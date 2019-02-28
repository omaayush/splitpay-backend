package splitwise.hu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import splitwise.hu.model.UsersSplitwise;
import splitwise.hu.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    private List<UsersSplitwise> allUsers= new ArrayList<UsersSplitwise>(Arrays.asList(
            new UsersSplitwise(201, "Aayush", "aayush@oye.com","12345", 123456789),
            new UsersSplitwise(202, "Aman", "aman@oye.com","12345", 123456789),
            new UsersSplitwise(203, "Ankesh", "ankesh@oye.com","12345", 123456789),
            new UsersSplitwise(204, "Divyank", "divyank@oye.com","12345", 123456789),
            new UsersSplitwise(205, "Deepak", "deepak@oye.com","12345", 123456789)
    ));

    @RequestMapping(value = "/saveUsers")
    public String saveAll(){
        userService.saveAllUsers(allUsers);
        return "All Users saved";
    }

    @RequestMapping("/users")
    public List<UsersSplitwise> getAllUsers() {
        List<UsersSplitwise> allUser = this.userService.getAllUsers();
        System.out.println(allUser);
        return allUser;
    }

    @RequestMapping("/users/{id}")
    public Optional<UsersSplitwise> getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/users", method= RequestMethod.POST)
    public void addUser(@RequestBody UsersSplitwise user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/users/{id}", method= RequestMethod.PUT)
    public void updateUserById(@PathVariable long id,@RequestBody UsersSplitwise user) {
        userService.updateUserById(id,user);
    }

    @RequestMapping(value = "/users/{id}", method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/users/{id}/balance")
    public String balanceOfUserById(@PathVariable long id) {
        return userService.balanceOfUserById(id);
    }
}
