package splitwise.hu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import splitwise.hu.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
