package splitwise.hu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import splitwise.hu.model.GroupSplitwise;

@Repository
public interface GroupRepository extends JpaRepository<GroupSplitwise,Long> {
}
