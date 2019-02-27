package splitwise.hu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name = "Bill")
public class Bill extends AuditModel{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_Id")
    private Integer id;

    @Column(name = "purposeOfBill")
    private String purposeOfBill;

    @Column(name = "amount")
    private float amount;

    @Column(name = "groupId")
    private Integer groupId;

    @Column(name = "paidByUserId")
    private Integer paidByUserId;

    public Bill() {
    }

    public Bill(Integer id, String purposeOfBill, float amount, Integer groupId, Integer paidByUserId) {
        this.id = id;
        this.purposeOfBill = purposeOfBill;
        this.amount = amount;
        this.groupId = groupId;
        this.paidByUserId = paidByUserId;
    }

    //    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Set<User> users;

    //private HashMap<Integer,Integer> splitBillsOfAllTheUsers;


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

