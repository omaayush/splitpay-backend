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
            new GroupSplitwise(102,"Group2"),
            new GroupSplitwise(103,"Group3")
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
        this.applicationService.addBillToGroup( 303,102);
        this.applicationService.addBillToGroup( 304,103);
        this.applicationService.addBillToGroup( 305,103);
        return "Bills added to Group";
    }

    @GetMapping (value = "/saveUsersToGroups")
    public String addUsersToGroup(){
        this.applicationService.addUserToGroup( 201,101);
        this.applicationService.addUserToGroup( 202,101);
        this.applicationService.addUserToGroup( 203,102);
        this.applicationService.addUserToGroup( 204,102);
        this.applicationService.addUserToGroup( 205,102);
        this.applicationService.addUserToGroup( 206,103);
        this.applicationService.addUserToGroup( 207,103);
        this.applicationService.addUserToGroup( 208,103);
        return "Users added to Groups";
    }

    @GetMapping (value = "/saveUsersToBills")
    public String addUsersToBill(){
        this.applicationService.addUserToBill( 201,301);
        this.applicationService.addUserToBill( 201,302);
        this.applicationService.addUserToBill( 202,302);
        this.applicationService.addUserToBill( 203,303);
        this.applicationService.addUserToBill( 205,303);
        this.applicationService.addUserToBill( 206,304);
        this.applicationService.addUserToBill( 207,304);
        this.applicationService.addUserToBill( 207,305);
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



    //---------------------------------------------

    @RequestMapping (value = "/groups/{groupId}/addUser/{userId}")
    public String addUserToGroup(@PathVariable long groupId, @PathVariable long userId){
        this.applicationService.addUserToGroup(userId,groupId);
        return "User Added to Group";
    }

    @RequestMapping (value = "/groups/{groupId}/addBill/{billId}")
    public String addBillToGroup(@PathVariable long billId, @PathVariable long groupId){
        this.applicationService.addBillToGroup(billId,groupId);
        return "Bill added to Group";
    }

    @RequestMapping (value = "/bills/{billId}/addUser/{userId}")
    public String addUserToBill(@PathVariable long billId, @PathVariable long userId){
         this.applicationService.addUserToBill(userId,billId);
         return "User added to Bill";
    }

    //-----------------------------------------------------------

    @RequestMapping(value="/bills/{id}/balance")
    public String getBillBalanceString(@PathVariable("id") long id)
    {
        return this.applicationService.getBillBalanceString(id);
    }

    @RequestMapping(value="/groups/{id}/balance")
    public String getGroupBalance(@PathVariable("id") long id)
    {
        return this.applicationService.getGroupBalance(id);
    }

    @RequestMapping(value="/users/{id}/balance")
    public String getUserBalance(@PathVariable("id") long id)
    {
        return this.applicationService.getUserBalance(id);
    }

    @RequestMapping(value="/users/{id}/groups")
    public List getGroupsFromUserId(@PathVariable("id") long id)
    {
        return this.applicationService.getGroupsFromUserId(id);
    }

    @RequestMapping(value="users/{id}/friends")
    public List getFriendsFromUserId(@PathVariable("id") long id)
    {
        return this.applicationService.getFriendsFromUserId(id);
    }

}
