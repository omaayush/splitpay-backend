package splitwise.hu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private List<User> user= new ArrayList<User>(Arrays.asList(
            new User(1, "Aayush", "aayush@aaaa.com", 123456789),
            new User(2, "Varshney", "aayush@aaaa.com", 123456789),
            new User(3, "hey", "aayush@aaaa.com", 123456789),
            new User(4, "hello", "aayush@aaaa.com", 123456789),
            new User(5, "hi", "aayush@aaaa.com", 123456789)
    ));

    protected UserService() {}


    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        List<User> allUser = new ArrayList<>();
        userRepository.findAll().forEach(allUser::add);
        return allUser;
//       return user;
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}



//    @Autowired
//    private EmployeeStore employeeStore;
//
//    @Autowired
//    public EmployeeService(EmployeeStore employeeStore) {
//        this.employeeStore = employeeStore;
//    }

//    public List<Employee> getAllEmployees() {
//        return employees;
//        //return this.employeeStore.getAllEmployees();
//    }
