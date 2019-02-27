package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.GroupSplitwise;

@Service
public class ApplicationService {

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    BillService billService;

    public String addUserToGroup(long groupId, long userId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        group.getMembersOfGroup().add(userService.getUserById(userId).get());
        groupService.addGroup(group);
        return "Added "+userId+" to "+groupId;
    }

    public String addBillToGroup(long groupId, long billId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        group.setGroupId(groupId);
        groupService.addGroup(group);
        return "Added "+billId+" to "+groupId;
    }
}
