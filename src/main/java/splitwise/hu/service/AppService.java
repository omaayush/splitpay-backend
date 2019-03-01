//package splitwise.hu.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import splitwise.hu.model.Bill;
//import splitwise.hu.model.GroupSplitwise;
//import splitwise.hu.model.UsersSplitwise;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class AppService {
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
//    public boolean hasBillBalance(long id) {
////        Bill bill= billService.getBillById(id).get();
////        List<UsersSplitwise> usersInBill=bill.getUsersInBill();
////        HashMap<Long,Float> balance=new HashMap<>();
////        long paidBy=bill.getPaidByUserId();
////        float split=bill.getBillAmount()/bill.getUsersInBill().size();
////        for (UsersSplitwise tempUser : usersInBill)
////        {
////            balance.put(tempUser.getId(),(0-split));
////        }
////        //System.out.println("bill.getBillAmount() "+bill.getBillAmount());
////        //System.out.println("balance.get(paidBy)"+balance.get(paidBy));
////        //balance.put(paidBy,(balance.get(paidBy)+bill.getBillAmount()));
//        return true;
//
//    }
//
//}
