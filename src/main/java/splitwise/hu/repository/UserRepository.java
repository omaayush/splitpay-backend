package splitwise.hu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import splitwise.hu.model.UsersSplitwise;

@Repository
public interface UserRepository extends JpaRepository<UsersSplitwise, Long> {

}
