package splitwise.hu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import splitwise.hu.model.Bill;
import splitwise.hu.service.BillService;
import java.util.List;
import java.util.Optional;

@RestController
public class BillController {


    @Autowired
    BillService billService;


    @RequestMapping("/bills")
    public List<Bill> getAllUsers() {
        List<Bill> allBill = this.billService.getAllBills();
        System.out.println(allBill);
        return allBill;
    }

    @RequestMapping("/bills/{id}")
    public Optional<Bill> getUserById(@PathVariable int id) {
        return billService.getBillById(id);
    }

    @RequestMapping(value = "/bills/{id}", method= RequestMethod.PUT)
    public void updateUserById(@PathVariable long id,@RequestBody Bill bill) {
        billService.updateBillById(id,bill);
    }

    @RequestMapping(value = "/bills", method= RequestMethod.POST)
    public void addUser(@RequestBody Bill bill) {
        billService.addBill(bill);
    }

    @RequestMapping(value = "/bills/{id}", method=RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id) {
        billService.deleteBill(id);
    }
}
