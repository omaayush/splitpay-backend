package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.Bill;
import splitwise.hu.model.GroupSplitwise;
import splitwise.hu.model.UsersSplitwise;
import javax.sound.midi.Soundbank;
import java.util.*;

@Service
public class ApplicationService {

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    BillService billService;

    private List<UsersSplitwise> allUsers= new ArrayList<UsersSplitwise>(Arrays.asList(
            new UsersSplitwise(201, "Aayush", "aayush@oye.com","12345", 123456789),
            new UsersSplitwise(202, "Aman", "aman@oye.com","12345", 123456789),
            new UsersSplitwise(203, "Ankesh", "ankesh@oye.com","12345", 123456789),
            new UsersSplitwise(204, "Divyank", "divyank@oye.com","12345", 123456789),
            new UsersSplitwise(205, "Deepak", "deepak@oye.com","12345", 123456789)
    ));

    public String addUserToGroup(long userId, long groupId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        group.getMembersOfGroup().add(userService.getUserById(userId).get());
        groupService.addGroup(group);
        return "Added UserId = "+userId+" to GroupId = "+groupId;
    }

    public void addBillToGroup(long billId, long groupId) {
        GroupSplitwise group = groupService.getGroupById(groupId).get();
        Bill bill=billService.getBillById(billId).get();
        bill.setBillForGroup(group);
        List<Bill> previousBill=group.getBillsInGroup();
        previousBill.add(bill);
        group.setBillsInGroup(previousBill);
        //group.setBillsInGroup(group.getBillsInGroup().add(billService.getBillById(billId)));
        //group.getBillsInGroup().add(billService.getBillById(billId).get());
        groupService.addGroup(group);
        //System.out.println("Added BillId = "+billId+" to GroupId = "+groupId);
        //System.out.println(group.toString());
        System.out.println(groupService.getGroupById(groupId).get().getBillsInGroup().size());

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
        //userService.getUserById(id).get().getGroupsOfUser().size()
        System.out.println("groups where user belong"+
                userService.getUserById(id).get().getGroupsOfUser().size());
        System.out.println("bills where user belongs"+
                userService.getUserById(id).get().getBillsOfUser().size());
        return null;

    }

    public String getBillBalanceString(long id) {
        return this.getBillBalance(id).toString();
    }

    public List getFriendsFromUserId(long id) {
        UsersSplitwise user=userService.getUserById(id).get();
        HashSet<UsersSplitwise> friends=new HashSet<>();
        List <String>frie=new ArrayList();
        List<GroupSplitwise> allGroups=user.getGroupsOfUser();
        for(GroupSplitwise group:allGroups)
        {List<UsersSplitwise> userss=group.getMembersOfGroup();
            for (UsersSplitwise users:userss)
                frie.add(users.getUserName());
            //friends.addAll(group.getMembersOfGroup());
        }
//        String ret= "<Html> <H1>Friends of user are - </H1> <br><ul>";
//        for(UsersSplitwise use:friends)
//        {
//          ret+="<li>"+use.getUserName()+"</li>";
//        }
//        ret+="</ul> </html>";
        return frie;

    }

    public List getGroupsFromUserId(long id) {
        UsersSplitwise user=userService.getUserById(id).get();
        List<GroupSplitwise> group= user.getGroupsOfUser();
        List<String> groups=new ArrayList<>();
        for (GroupSplitwise grp:group)
            groups.add(grp.getGroupName());
        return group;
    }

    public boolean getBillBalanceWithUser(Bill bill,UsersSplitwise user) {
    //            List<UsersSplitwise> usersInBill=bill.getUsersInBill();
    //            HashMap<Long,Float> balance=new HashMap<>();
    //            long paidBy=bill.getPaidByUserId();
    //            float split=bill.getBillAmount()/bill.getUsersInBill().size();
    //            for (UsersSplitwise tempUser : usersInBill)
    //            {
    //                balance.put(tempUser.getId(),(0-split));
    //            }
    //            //System.out.println("bill.getBillAmount() "+bill.getBillAmount());
    //            //System.out.println("balance.get(paidBy)"+balance.get(paidBy));
    //            balance.put(paidBy,(balance.get(paidBy)+bill.getBillAmount()));
            return true;

    }
}
