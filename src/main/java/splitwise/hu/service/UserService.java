package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.UsersSplitwise;
import splitwise.hu.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    protected UserService() {}


    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<UsersSplitwise> getAllUsers() {
        List<UsersSplitwise> allUser = new ArrayList<>();
        userRepository.findAll().forEach(allUser::add);
        return allUser;
    }

//    working
//    public List<UsersSplitwise> getAllUsers(){
//        return userRepository.findAll();
//    }

    public void saveAllUsers(List<UsersSplitwise> allUsers) {
        userRepository.saveAll(allUsers);
    }

    public Optional<UsersSplitwise> getUserById(long id) {
        return userRepository.findById(id);
    }

    public void addUser(UsersSplitwise user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUserById(long id, UsersSplitwise user) {
//        UsersSplitwise usersSplitwise= userRepository.findById(id).get();
//        usersSplitwise.setUserName(user.getUserName());
//        usersSplitwise.setContactNumber(user.getContactNumber());
//        usersSplitwise.setPassword(user.getPassword());
//        usersSplitwise.setEmailId(user.getEmailId());
        userRepository.save(user);
    }

    public String balanceOfUserById(long id) {
        //return userRepository.findById(id).get();
        return null;
    }
}