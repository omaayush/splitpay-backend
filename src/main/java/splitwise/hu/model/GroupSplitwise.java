package splitwise.hu.model;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property = "groupId")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
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

  @ManyToMany(cascade = CascadeType.ALL)
  @JsonIgnore
  //@LazyCollection(LazyCollectionOption.FALSE)
  //@JsonIgnoreProperties
  private List<UsersSplitwise> membersOfGroup = new ArrayList<UsersSplitwise>();

  @OneToMany (cascade = CascadeType.ALL,mappedBy = "billOfGroup")
  @JsonIgnore
  //@LazyCollection(LazyCollectionOption.FALSE)
  //@JsonIgnoreProperties
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
