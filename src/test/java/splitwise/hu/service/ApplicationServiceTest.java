package splitwise.hu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import splitwise.hu.model.Bill;
import splitwise.hu.model.GroupSplitwise;
import splitwise.hu.model.UsersSplitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class ApplicationServiceTest {


    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    BillService billService;

    @Autowired
    ApplicationService applicationService;

    private List<UsersSplitwise> allUsers= new ArrayList<UsersSplitwise>(Arrays.asList(
            new UsersSplitwise(201, "Aayush", "aayush@oye.com","12345", 123456789),
            new UsersSplitwise(202, "Aman", "aman@oye.com","12345", 123456789),
            new UsersSplitwise(203, "Ankesh", "ankesh@oye.com","12345", 123456789),
            new UsersSplitwise(204, "Divyank", "divyank@oye.com","12345", 123456789),
            new UsersSplitwise(205, "Deepak", "deepak@oye.com","12345", 123456789)
    ));
    private List<GroupSplitwise> allGroups=new ArrayList<>(Arrays.asList(
            new GroupSplitwise(101,"Group1"),
            new GroupSplitwise(102,"Group2")
//            new GroupSplitwise(103,"Group3"),
//            new GroupSplitwise(104,"Group4"),
//            new GroupSplitwise(105,"Group5")
    ));
    private List<Bill> allBills= new ArrayList<Bill>(Arrays.asList(
            new Bill(301,"Party1", 100, 201),
            new Bill(302,"Party2", 200, 202),
            new Bill(303,"Party3", 300, 205),
            new Bill(304,"Party4", 400, 203)
            //new Bill(405,"Party5", 500, 205)
    ));

//AppService ApplicationService;
//    public String addBillsToGroups(){
//        this.applicationService.addBillToGroup( 301,101);
//        this.applicationService.addBillToGroup( 302,101);
//        this.applicationService.addBillToGroup( 303,101);
//        this.applicationService.addBillToGroup( 304,102);
//        System.out.println(groupService.getGroupById(101).get().getBillsInGroup().size());
//        System.out.println(groupService.getGroupById(102).get().getBillsInGroup().size());
//        return "Bills added to Group";
//    }
//
//    public String addUsersToGroup(){
//        this.applicationService.addUserToGroup( 201,101);
//        this.applicationService.addUserToGroup( 202,101);
//        this.applicationService.addUserToGroup( 203,102);
//        this.applicationService.addUserToGroup( 204,102);
//        this.applicationService.addUserToGroup( 205,101);
//        this.applicationService.addUserToGroup( 205,102);
//        return "Users added to Groups";
//    }
//
//    public String addUsersToBill(){
//        this.applicationService.addUserToBill( 201,301);
//        this.applicationService.addUserToBill( 201,302);
//        this.applicationService.addUserToBill( 202,302);
//        this.applicationService.addUserToBill( 201,303);
//        this.applicationService.addUserToBill( 202,303);
//        this.applicationService.addUserToBill( 205,303);
//        this.applicationService.addUserToBill( 203,304);
//        this.applicationService.addUserToBill( 205,304);
//        return "Users added to Bills";
//    }


    @Test
    public void addingUserToGroup(){
        UsersSplitwise user1= new UsersSplitwise(201, "Aayush",
                "aayush@oye.com","12345", 123456789);
        UsersSplitwise user2= new UsersSplitwise(202, "Aman",
                "aman@oye.com","12345", 123456789);
        UsersSplitwise user3= new UsersSplitwise(203, "Ankesh",
                "ankesh@oye.com","12345", 123456789);
        UsersSplitwise user4=new UsersSplitwise(204, "Divyank",
                "divyank@oye.com","12345", 123456789);
        UsersSplitwise user5=new UsersSplitwise(205, "Deepak",
                "deepak@oye.com","12345", 123456789);
        GroupSplitwise group1=new GroupSplitwise(101,"Group1");
        GroupSplitwise group2=new GroupSplitwise(102,"Group2");
        Bill bill1=new Bill(301,"Party1", 100, 201);
        Bill bill2=new Bill(302,"Party2", 200, 202);
        Bill bill3=new Bill(303,"Party3", 300, 205);
        Bill bill4=new Bill(304,"Party4", 400, 203);
        user1.setBillsOfUser(allBills);
        user1.setGroupsOfUser(allGroups);
        assertEquals(false,user1.getGroupsOfUser().isEmpty());
//        groupService.saveAllGroups(allGroups);
//        billService.saveAllBills(allBills);
//        this.applicationService.addBillToGroup( 302,101);
//        assertEquals(groupService.getGroupById(101).get().getBillsInGroup().size(),3);
    }

    @Test
    public void addingBillToGroup(){
        UsersSplitwise user1= new UsersSplitwise(201, "Aayush",
                "aayush@oye.com","12345", 123456789);
        UsersSplitwise user2= new UsersSplitwise(202, "Aman",
                "aman@oye.com","12345", 123456789);
        UsersSplitwise user3= new UsersSplitwise(203, "Ankesh",
                "ankesh@oye.com","12345", 123456789);
        UsersSplitwise user4=new UsersSplitwise(204, "Divyank",
                "divyank@oye.com","12345", 123456789);
        UsersSplitwise user5=new UsersSplitwise(205, "Deepak",
                "deepak@oye.com","12345", 123456789);
        GroupSplitwise group1=new GroupSplitwise(101,"Group1");
        GroupSplitwise group2=new GroupSplitwise(102,"Group2");
        Bill bill1=new Bill(301,"Party1", 100, 201);
        Bill bill2=new Bill(302,"Party2", 200, 202);
        Bill bill3=new Bill(303,"Party3", 300, 205);
        Bill bill4=new Bill(304,"Party4", 400, 203);
        user1.setBillsOfUser(allBills);
        user1.setGroupsOfUser(allGroups);
        bill1.setBillForGroup(group1);
        group1.getBillsInGroup().add(bill1);
        assertEquals(false,group1.getBillsInGroup().isEmpty());
//        groupService.saveAllGroups(allGroups);
//        billService.saveAllBills(allBills);
//        this.applicationService.addBillToGroup( 302,101);
//        assertEquals(groupService.getGroupById(101).get().getBillsInGroup().size(),3);
    }

    @Test
    public void addingUserInBill(){
        UsersSplitwise user1= new UsersSplitwise(201, "Aayush",
                "aayush@oye.com","12345", 123456789);
        UsersSplitwise user2= new UsersSplitwise(202, "Aman",
                "aman@oye.com","12345", 123456789);
        UsersSplitwise user3= new UsersSplitwise(203, "Ankesh",
                "ankesh@oye.com","12345", 123456789);
        UsersSplitwise user4=new UsersSplitwise(204, "Divyank",
                "divyank@oye.com","12345", 123456789);
        UsersSplitwise user5=new UsersSplitwise(205, "Deepak",
                "deepak@oye.com","12345", 123456789);
        GroupSplitwise group1=new GroupSplitwise(101,"Group1");
        GroupSplitwise group2=new GroupSplitwise(102,"Group2");
        Bill bill1=new Bill(301,"Party1", 100, 201);
        bill1.setUsersInBill(allUsers);
        List<UsersSplitwise> userFromService=bill1.getUsersInBill();

        Bill bill2=new Bill(302,"Party2", 200, 202);
        Bill bill3=new Bill(303,"Party3", 300, 205);
        Bill bill4=new Bill(304,"Party4", 400, 203);
        user1.setBillsOfUser(allBills);
//        user1.setGroupsOfUser(allGroups);
//        bill1.setBillForGroup(group1);
//        group1.getBillsInGroup().add(bill1);

        assertEquals(false,userFromService.isEmpty());
//        groupService.saveAllGroups(allGroups);
//        billService.saveAllBills(allBills);
//        this.applicationService.addBillToGroup( 302,101);
//        assertEquals(groupService.getGroupById(101).get().getBillsInGroup().size(),3);
    }

//    @Test
//    public void hasBillBalance()
//    {
//        UsersSplitwise user1= new UsersSplitwise(201, "Aayush",
//                "aayush@oye.com","12345", 123456789);
//        UsersSplitwise user2= new UsersSplitwise(202, "Aman",
//                "aman@oye.com","12345", 123456789);
//        UsersSplitwise user3= new UsersSplitwise(203, "Ankesh",
//                "ankesh@oye.com","12345", 123456789);
//        UsersSplitwise user4=new UsersSplitwise(204, "Divyank",
//                "divyank@oye.com","12345", 123456789);
//        UsersSplitwise user5=new UsersSplitwise(205, "Deepak",
//                "deepak@oye.com","12345", 123456789);
//        GroupSplitwise group1=new GroupSplitwise(101,"Group1");
//        GroupSplitwise group2=new GroupSplitwise(102,"Group2");
//        Bill bill1=new Bill(301,"Party1", 100, 201);
//        bill1.setUsersInBill(allUsers);
//        List<UsersSplitwise> userFromService=bill1.getUsersInBill();
//
//        Bill bill2=new Bill(302,"Party2", 200, 202);
//        Bill bill3=new Bill(303,"Party3", 300, 205);
//        Bill bill4=new Bill(304,"Party4", 400, 203);
//        user1.setBillsOfUser(allBills);
//
////        user1.setGroupsOfUser(allGroups);
////        bill1.setBillForGroup(group1);
////        group1.getBillsInGroup().add(bill1);
//       // float a=201F;
//        assertEquals(true,this.applicationService.getBillBalanceWithUser(bill1,user1));

//    }

}