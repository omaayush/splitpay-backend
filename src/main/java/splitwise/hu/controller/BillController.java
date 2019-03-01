package splitwise.hu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import splitwise.hu.model.Bill;
import splitwise.hu.service.BillService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class BillController {


    @Autowired
    BillService billService;

    private List<Bill> allBills= new ArrayList<Bill>(Arrays.asList(
            new Bill(301,"Party1", 100, 201),
            new Bill(302,"Party2", 200, 202),
            new Bill(303,"Party3", 300, 205),
            new Bill(304,"Party4", 400, 206),
            new Bill(305,"Party5", 500, 207)
            //new Bill(405,"Party5", 500, 205)
    ));


    @RequestMapping(value = "/saveBills")
    public String saveAll(){
        billService.saveAllBills(allBills);
        return "All Bills saved";
    }


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
