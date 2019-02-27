package splitwise.hu.model;

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
  private List<GroupSplitwise> groupsOfUser = new ArrayList<>();


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
