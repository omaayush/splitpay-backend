package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.Bill;
import splitwise.hu.model.GroupSplitwise;
import splitwise.hu.model.UsersSplitwise;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;

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

    public void addBillToGroup(long billId, long groupId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        group.getBillsInGroup().add(billService.getBillById(billId).get());
        groupService.addGroup(group);
        System.out.println("Added BillId = "+billId+" to GroupId = "+groupId);
        //System.out.println(group.toString());
        System.out.println(groupService.getGroupById(groupId).get().getBillsInGroup().toString());

    }

    public String addUserToBill(long userId, long billId) {
        Bill bill = billService.getBillById(billId).get();
        bill.getUsersInBill().add(userService.getUserById(userId).get());
        billService.addBill(bill);
        return "Added UserId = "+userId+" to billId = "+billId;
    }

    public HashMap<Long,Float> getBillBalance(long id) {
        Bill bill= billService.getBillById(id).get();
        List<UsersSplitwise> usersInBill=bill.getUsersInBill();
        HashMap<Long,Float> balance=new HashMap<>();
        long paidBy=bill.getPaidByUserId();
        float split=bill.getBillAmount()/bill.getUsersInBill().size();
        for (UsersSplitwise tempUser : usersInBill)
        {
            balance.put(tempUser.getId(),(0-split));
        }
        //System.out.println("bill.getBillAmount() "+bill.getBillAmount());
        //System.out.println("balance.get(paidBy)"+balance.get(paidBy));
        balance.put(paidBy,(balance.get(paidBy)+bill.getBillAmount()));
        return balance;

    }

    public String getGroupBalance(long id) {
        GroupSplitwise group=groupService.getGroupById(id).get();
        List<UsersSplitwise> usersInGroup=group.getMembersOfGroup();
        List<Bill> allBills=group.getBillsInGroup();
        //System.out.println("usersInGroup.toString() "+usersInGroup.toString());
        System.out.println("Bills in group - " +allBills.toString());

        HashMap<Long,Float> groupBalance=new HashMap<>();
        for (UsersSplitwise user: usersInGroup)
        {
            groupBalance.put(user.getId(),0F);
        }

        System.out.println("groupBalance"+groupBalance.toString());
        for (Bill bill : allBills)
        {
            HashMap<Long,Float> billTemp=getBillBalance(bill.getBillId());
            //System.out.println("billTemp"+billTemp.toString());

            for(Long billId :billTemp.keySet())
            groupBalance.put(billId,groupBalance.get(billId)+billTemp.get(billId));
        }

        return groupBalance.toString();
    }

    public String getUserBalance(long id) {
        GroupSplitwise group=groupService.getGroupById(id).get();
        HashMap<UsersSplitwise,Integer> balance=new HashMap<>();
        return null;

    }

    public String getBillBalanceString(long id) {
        return this.getBillBalance(id).toString();
    }
}
