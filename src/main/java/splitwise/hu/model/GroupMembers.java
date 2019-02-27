package splitwise.hu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "GroupMembers")
public class GroupMembers {

    @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private int id;

    //@Column(name = "username")
    private String name;

    //@Column(name = "email")
    private String email;

    //@Column(name = "contactnumber")
    private long contactNumber;




}

