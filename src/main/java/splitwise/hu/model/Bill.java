package splitwise.hu.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "Bill")
//public class Bill extends AuditModel{
public class Bill{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "bill_Id")
    private long billId;

    //@Column(name = "purposeOfBill")
    private String purposeOfBill;

    //@Column(name = "amount")
    private float billAmount;

    //@Column(name = "paidByUserId")
    private Integer paidByUserId;

    @ManyToOne
    private GroupSplitwise billOfGroup;

    //------later------------------error1
//    @OneToMany (mappedBy = "billsOfUser", fetch = FetchType.EAGER)
//    private List<UsersSplitwise> usersInBill;
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonBackReference
    private List<UsersSplitwise> usersInBill;

    public Bill() {
    }

    public GroupSplitwise getBillOfGroup() {
        return billOfGroup;
    }

    public void setBillOfGroup(GroupSplitwise billOfGroup) {
        this.billOfGroup = billOfGroup;
    }

    public List<UsersSplitwise> getUsersInBill() {
        return usersInBill;
    }

    public void setUsersInBill(List<UsersSplitwise> usersInBill) {
        this.usersInBill = usersInBill;
    }

    public Bill(long billId, String purposeOfBill, float billAmount, Integer paidByUserId) {
        this.billId = billId;
        this.purposeOfBill = purposeOfBill;
        this.billAmount = billAmount;
        this.paidByUserId = paidByUserId;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public String getPurposeOfBill() {
        return purposeOfBill;
    }

    public void setPurposeOfBill(String purposeOfBill) {
        this.purposeOfBill = purposeOfBill;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public Integer getPaidByUserId() {
        return paidByUserId;
    }

    public void setPaidByUserId(Integer paidByUserId) {
        this.paidByUserId = paidByUserId;
    }

    public GroupSplitwise getBillForGroup() {
        return billOfGroup;
    }

    public void setBillForGroup(GroupSplitwise billForGroup) {
        this.billOfGroup = billForGroup;
    }

    //    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Set<UsersSplitwise> users;

    //private HashMap<Integer,Integer> splitBillsOfAllTheUsers;

}

