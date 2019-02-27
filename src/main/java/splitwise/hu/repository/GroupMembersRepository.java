package splitwise.hu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import splitwise.hu.model.GroupMembers;

@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers,Long> {
}
