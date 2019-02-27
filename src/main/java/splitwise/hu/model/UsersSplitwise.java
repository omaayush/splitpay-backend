package splitwise.hu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="UsersSplitwise")
//public class UsersSplitwise extends  AuditModel{
public class UsersSplitwise{
  @Id
  //@GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

  private String userName;

  private String emailId;

  private String password;

  private long contactNumber;

  @ManyToMany(mappedBy = "membersOfGroup")
  @LazyCollection(LazyCollectionOption.FALSE)
  @JsonBackReference
  private List<GroupSplitwise> groupsOfUser = new ArrayList<>();

  //----------later-------------
//  @ManyToOne//( mappedBy= "usersInBill", fetch = FetchType.EAGER)
//  private List<Bill> billsOfUser=new ArrayList<>();
  @ManyToMany(mappedBy = "usersInBill")
  @LazyCollection(LazyCollectionOption.FALSE)
  @JsonBackReference
  private List<Bill> billsOfUser=new ArrayList<>();


  public UsersSplitwise() {
  }

  public UsersSplitwise(long id, String userName, String emailId, String password, long contactNumber) {
    this.id = id;
    this.userName = userName;
    this.emailId = emailId;
    this.password = password;
    this.contactNumber = contactNumber;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(long contactNumber) {
    this.contactNumber = contactNumber;
  }

  public List<GroupSplitwise> getGroupsOfUser() {
    return groupsOfUser;
  }

  public void setGroupsOfUser(List<GroupSplitwise> groupsOfUser) {
    this.groupsOfUser = groupsOfUser;
  }

  public List<Bill> getBillsOfUser() {
    return billsOfUser;
  }

  public void setBillsOfUser(List<Bill> billsOfUser) {
    this.billsOfUser = billsOfUser;
  }
//  @OneToMany
//  @JoinColumn(name="group_id", nullable=false)
//  private Set<GroupSplitwise> group;


  //  public Set<GroupSplitwise> getGroup() {
//    return group;
//  }
//
//  public void setGroup(Set<GroupSplitwise> group) {
//    this.group = group;
//  }
//private HashMap<Integer,Integer> balances;
  //private ArrayList<Integer> groupIds;


}
