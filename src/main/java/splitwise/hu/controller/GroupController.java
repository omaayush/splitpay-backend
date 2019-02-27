package splitwise.hu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import splitwise.hu.model.GroupSplitwise;
import splitwise.hu.service.ApplicationService;
import splitwise.hu.service.GroupService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    ApplicationService applicationService;

    private List<GroupSplitwise> allGroups=new ArrayList<>(Arrays.asList(
            new GroupSplitwise(101,"Group1"),
            new GroupSplitwise(102,"Group2")
//            new GroupSplitwise(103,"Group3"),
//            new GroupSplitwise(104,"Group4"),
//            new GroupSplitwise(105,"Group5")
    ));

    @RequestMapping(value = "/saveGroups")
    public String saveAll(){
        groupService.saveAllGroups(allGroups);
        return "All Groups saved";
    }

    @GetMapping (value = "/saveBillsToGroups")
    public String addBillsToGroups(){
        this.applicationService.addBillToGroup( 301,101);
        this.applicationService.addBillToGroup( 302,101);
        this.applicationService.addBillToGroup( 303,101);
        this.applicationService.addBillToGroup( 304,102);
        return "Bills added to Group";
    }

    @GetMapping (value = "/saveUsersToGroups")
    public String addUsersToGroup(){
        this.applicationService.addUserToGroup( 201,101);
        this.applicationService.addUserToGroup( 202,101);
        this.applicationService.addUserToGroup( 203,102);
        this.applicationService.addUserToGroup( 204,102);
        this.applicationService.addUserToGroup( 205,101);
        this.applicationService.addUserToGroup( 205,102);
        return "Users added to Groups";
    }

    @GetMapping (value = "/saveUsersToBills")
    public String addUsersToBill(){
        this.applicationService.addUserToBill( 201,301);
        this.applicationService.addUserToBill( 201,302);
        this.applicationService.addUserToBill( 202,302);
        this.applicationService.addUserToBill( 201,303);
        this.applicationService.addUserToBill( 202,303);
        this.applicationService.addUserToBill( 203,303);
        this.applicationService.addUserToBill( 203,304);
        this.applicationService.addUserToBill( 205,304);
        return "Users added to Bills";
    }

    @RequestMapping("/groups")
    public List<GroupSplitwise> getAllGroups() {
        List<GroupSplitwise> allGroups = this.groupService.getAllGroups();
        System.out.println(allGroups);
        return allGroups;
    }

    @RequestMapping("/groups/{id}")
    public Optional<GroupSplitwise> getGroupById(@PathVariable long id) {
        return groupService.getGroupById(id);
    }

    @RequestMapping(value = "/groups", method= RequestMethod.POST)
    public void addUser(@RequestBody GroupSplitwise user) {
        groupService.addGroup(user);
    }

    @RequestMapping(value = "/groups/{id}", method= RequestMethod.PUT)
    public void updateUserById(@PathVariable long id,@RequestBody GroupSplitwise user) {
        groupService.updateGroupById(id,user);
    }

    @RequestMapping(value = "/groups/{id}", method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id) {
        groupService.deleteGroup(id);
    }

    @RequestMapping (value = "/groups/id={groupId}/addUser/userId={userId}")
    public String addUserToGroup(@PathVariable("groupId") long groupId, @PathVariable("userId") long userId){
        return this.applicationService.addUserToGroup(userId,groupId);
    }

    @GetMapping (value = "/groups/id={groupId}/addBill/billId={billId}")
    public String addBillToGroup(@PathVariable("billId") long billId, @PathVariable("groupId") long groupId){
        return this.applicationService.addBillToGroup(billId,groupId);
    }

    @RequestMapping (value = "/bills/id={billId}/addUser/userId={userId}")
    public String addUserToBill(@PathVariable("billId") long billId, @PathVariable("userId") long userId){
        return this.applicationService.addUserToBill(userId,billId);
    }

}
