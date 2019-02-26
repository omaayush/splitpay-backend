package splitwise.hu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name="user")
public class User {

  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

//  @Column(name = "username")
  private String username;

//  @Column(name = "email")
  private String email;

//  @Column(name = "contactnumber")
  private long contactNumber;

  public User() {
    super();
  }

  public User(int id, String name, String email, long contactNumber) {
    super();
    this.id = id;
    this.username = name;
    this.email = email;
    this.contactNumber = contactNumber;
  }

  private HashMap<Integer,Integer> balances;
  private ArrayList<Integer> groupIds;

  public String getEmail() {
    return email;
  }

  public long getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(long contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public HashMap<Integer, Integer> getBalances() {
    return balances;
  }

  public void setBalances(HashMap<Integer, Integer> balances) {
    this.balances = balances;
  }

  public ArrayList<Integer> getGroupIds() {
    return groupIds;
  }

  public void setGroupIds(ArrayList<Integer> groupIds) {
    this.groupIds = groupIds;
  }
}
