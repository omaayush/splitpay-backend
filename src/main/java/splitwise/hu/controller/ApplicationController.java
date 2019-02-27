//package splitwise.hu.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import splitwise.hu.model.Bill;
//import splitwise.hu.model.GroupSplitwise;
//import splitwise.hu.model.UsersSplitwise;
//import splitwise.hu.repository.GroupRepository;
//import splitwise.hu.repository.UserRepository;
//import splitwise.hu.service.ApplicationService;
//import splitwise.hu.service.BillService;
//import splitwise.hu.service.GroupService;
//import splitwise.hu.service.UserService;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class ApplicationController {
//
//    @Autowired
//    ApplicationService service;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    GroupService groupService;
//
//    @Autowired
//    BillService billService;
//
//    private List<Bill> allBills= new ArrayList<Bill>(Arrays.asList(
//            new Bill(1,"Party1", 100, 201),
//            new Bill(2,"Party2", 200, 202),
//            new Bill(3,"Party3", 300, 203),
//            new Bill(4,"Party4", 400, 204),
//            new Bill(5,"Party5", 500, 205)
//    ));
//
//    private List<UsersSplitwise> allUsers= new ArrayList<UsersSplitwise>(Arrays.asList(
//            new UsersSplitwise(201, "Aayush", "aayush@oye.com","12345", 123456789),
//            new UsersSplitwise(202, "Aman", "aman@oye.com","12345", 123456789),
//            new UsersSplitwise(203, "Ankesh", "ankesh@oye.com","12345", 123456789),
//            new UsersSplitwise(204, "Divyank", "divyank@oye.com","12345", 123456789),
//            new UsersSplitwise(205, "Deepak", "deepak@oye.com","12345", 123456789)
//    ));
//
//    private List<GroupSplitwise> allGroups=new ArrayList<>(Arrays.asList(
//            new GroupSplitwise(101,"Group1"),
//            new GroupSplitwise(102,"Group2"),
//            new GroupSplitwise(103,"Group3"),
//            new GroupSplitwise(104,"Group4"),
//            new GroupSplitwise(105,"Group5")
//    ));
//
//    @RequestMapping(value = "/saveAll")
//    public String saveAll(){
//        userService.saveAllUsers(allUsers);
//        billService.saveAllBills(allBills);
//        groupService.saveAllGroups(allGroups);
//        return "All Users, Bills and Groups saved";
//    }
//
//    @RequestMapping (value = "/groups/id={id}/add/userId={userId}")
//    public String addUserToGroup(@PathVariable("id") long groupId, @PathVariable("userId") long userId){
//        return this.service.addUserToGroup(groupId,userId);
//    }
//
//    @RequestMapping("/hello")
//    public String hi() {
//        return "hiaaayush";
//    }
//
//}
