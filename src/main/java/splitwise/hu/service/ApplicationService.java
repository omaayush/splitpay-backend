package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.Bill;
import splitwise.hu.model.GroupSplitwise;

@Service
public class ApplicationService {

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    BillService billService;

    public String addUserToGroup(long userId, long groupId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        group.getMembersOfGroup().add(userService.getUserById(userId).get());
        groupService.addGroup(group);
        return "Added UserId = "+userId+" to GroupId = "+groupId;
    }

    public String addBillToGroup(long billId, long groupId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        group.getBillsInGroup().add(billService.getBillById(billId).get());
        groupService.addGroup(group);
        return "Added BillId = "+billId+" to GroupId = "+groupId;
    }

    public String addUserToBill(long userId, long billId) {
        Bill bill = billService.getBillById(billId).get();
        bill.getUsersInBill().add(userService.getUserById(userId).get());
        billService.addBill(bill);
        return "Added UserId = "+userId+" to billId = "+billId;
    }
}
