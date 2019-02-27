package splitwise.hu.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

  @Id
  //@GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "user_id")
  private int id;

  @Column(name = "user_name")
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name="password")
  private String password;

  @Column(name = "contact_number")
  private long contactNumber;

//  @OneToMany
//  @JoinColumn(name="group_id", nullable=false)
//  private Set<Group> group;

  public User() {
    super();
  }

  public User(int id, String username, String email, String password, long contactNumber) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.contactNumber = contactNumber;
  }

  //  public Set<Group> getGroup() {
//    return group;
//  }
//
//  public void setGroup(Set<Group> group) {
//    this.group = group;
//  }
//private HashMap<Integer,Integer> balances;
  //private ArrayList<Integer> groupIds;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
