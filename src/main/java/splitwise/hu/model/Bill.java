package splitwise.hu.model;
import javax.persistence.*;

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

    //@Column(name = "groupId")
    //private Integer groupId;

    //@Column(name = "paidByUserId")
    private Integer paidByUserId;

    @ManyToOne
    private GroupSplitwise billForGroup;

    public Bill() {
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
        return billForGroup;
    }

    public void setBillForGroup(GroupSplitwise billForGroup) {
        this.billForGroup = billForGroup;
    }

    //    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Set<UsersSplitwise> users;

    //private HashMap<Integer,Integer> splitBillsOfAllTheUsers;

}

