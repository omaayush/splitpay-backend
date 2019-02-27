package splitwise.hu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import splitwise.hu.model.GroupSplitwise;
import splitwise.hu.service.GroupService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {

    @Autowired
    GroupService groupService;

    private List<GroupSplitwise> allGroups=new ArrayList<>(Arrays.asList(
            new GroupSplitwise(101,"Group1"),
            new GroupSplitwise(102,"Group2"),
            new GroupSplitwise(103,"Group3"),
            new GroupSplitwise(104,"Group4"),
            new GroupSplitwise(105,"Group5")
    ));

    @RequestMapping(value = "/saveGroups")
    public String saveAll(){
        groupService.saveAllGroups(allGroups);
        return "All Groups saved";
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
}
