package splitwise.hu;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
  private int id;
  private String name;
  private String email;
  private HashMap<Integer,Integer> balances;
  private ArrayList<Integer> groupIds;

  public String getEmail() {
    return email;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
