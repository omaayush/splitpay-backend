package splitwise.hu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import splitwise.hu.model.Bill;
import splitwise.hu.repository.BillRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

  @Autowired
  private BillRepository billRepository;

  protected BillService() {}


  public BillService(BillRepository billRepository)
  {
    this.billRepository = billRepository;
  }

  public List<Bill> getAllBills() {
    List<Bill> allBills = new ArrayList<>();
    billRepository.findAll().forEach(allBills::add);
    return allBills;
  }

  public void saveAllBills(List<Bill> allBills) {
    billRepository.saveAll(allBills);
  }

  public Optional<Bill> getBillById(long id)
  {
    return billRepository.findById(id);
  }

  public void addBill(Bill bill) {
    billRepository.save(bill);
  }

  public void deleteBill(long id) {
    billRepository.deleteById(id);
  }


  public void updateBillById(long id, Bill bill) {
    billRepository.save(bill);
  }

}
