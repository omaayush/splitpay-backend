package splitwise.hu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private List<User> allUsers= new ArrayList<User>(Arrays.asList(
            new User(1, "Aayush", "aayush@aaaa.com", 123456789),
            new User(2, "Varshney", "aayush@aaaa.com", 123456789),
            new User(3, "hey", "aayush@aaaa.com", 123456789),
            new User(4, "hello", "aayush@aaaa.com", 123456789),
            new User(5, "hi", "aayush@aaaa.com", 123456789)
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
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user", method= RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/user/{id}", method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
    }
}


//package splitwise.hu;
//
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.List;
//        import java.util.Optional;
//
//@RestController
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeStore employeeStore;
//
//    @Autowired
//    private UserService employeeService;
//
//    @Autowired
//    public EmployeeController(EmployeeStore employeeStore, UserService employeeService) {
//        this.employeeStore = employeeStore;
//        this.employeeService = employeeService;
//        CSVFileReader reader = new CSVFileReader(this.employeeStore);
//        String path = "/home/aayush_varshney/leave-tracker-java/src/main/CSV_Files/employees.csv";
//
//        reader.loadEmployeeFromCSV(path);
//
//        this.employeeStore.getAllEmployees().forEach(employee -> {
//            employeeService.addEmployee(employee);
//        });
//    }
//    @RequestMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        List<Employee> allEmployees = this.employeeService.getAllEmployees();
//        System.out.println(allEmployees);
//        return allEmployees;
//    }
//
//    @RequestMapping("/employees/{id}")
//    public Optional<Employee> getEmployeeById(@PathVariable int id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//    @RequestMapping(value = "/employees", method= RequestMethod.POST)
//    public void addEmployee(@RequestBody Employee employee) {
//        employeeService.addEmployee(employee);
//    }
//
//    @RequestMapping(value = "/employees/{id}", method=RequestMethod.DELETE)
//    public void deleteEmployeeById(@PathVariable int id) {
//        employeeService.deleteEmployee(id);
//    }
//}
