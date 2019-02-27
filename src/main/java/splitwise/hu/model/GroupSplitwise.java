package splitwise.hu.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "GroupSplitwise")
//public class GroupSplitwise extends AuditModel
public class GroupSplitwise
{

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  //@Column(name = "group_id")
  private long groupId;

  //@Column(name = "group_name")
  private String groupName;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<UsersSplitwise> membersOfGroup = new ArrayList<UsersSplitwise>();

  @OneToMany (mappedBy = "billOfGroup")
  private List<Bill> billsInGroup = new ArrayList<>();

  public GroupSplitwise() {
    }

  public GroupSplitwise(long groupId, String groupName) {
    this.groupId = groupId;
    this.groupName = groupName;
  }

  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public List<UsersSplitwise> getMembersOfGroup() {
    return membersOfGroup;
  }

  public void setMembersOfGroup(List<UsersSplitwise> membersOfGroup) {
    this.membersOfGroup = membersOfGroup;
  }

  public List<Bill> getBillsInGroup() {
    return billsInGroup;
  }

  public void setBillsInGroup(List<Bill> billsInGroup) {
    this.billsInGroup = billsInGroup;
  }
}
