package splitwise.hu;

//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Bill {
//  private int id;
//  private int paidBy;
//  private HashMap<Integer,Integer> splitBillsOfAllTheUsers;
//
//}
import javax.persistence.*;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "purposeOfBill")
    private String purposeOfBill;

    @Column(name = "amount")
    private float amount;

    @Column(name = "groupId")
    private Integer groupId;

    @Column(name = "paidByUserId")
    private Integer paidByUserId;

    public Bill(Integer id, String purposeOfBill, float amount, Integer groupId, Integer paidByUserId) {
        this.id = id;
        this.purposeOfBill = purposeOfBill;
        this.amount = amount;
        this.groupId = groupId;
        this.paidByUserId = paidByUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurposeOfBill() {
        return purposeOfBill;
    }

    public void setPurposeOfBill(String purposeOfBill) {
        this.purposeOfBill = purposeOfBill;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPaidByUserId() {
        return paidByUserId;
    }

    public void setPaidByUserId(Integer paidByUserId) {
        this.paidByUserId = paidByUserId;
    }
}

