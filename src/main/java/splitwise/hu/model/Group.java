package splitwise.hu.model;
import javax.persistence.*;

@Entity
@Table(name = "Group")
public class Group
{

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "group_id")
  private Integer groupId;

  @Column(name = "group_name")
  private String groupName;

  public Group() {
    }

  public Group(Integer groupId, String groupName) {
    this.groupId = groupId;
    this.groupName = groupName;
  }

  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }
}
