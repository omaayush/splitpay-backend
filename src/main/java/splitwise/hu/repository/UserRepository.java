package splitwise.hu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import splitwise.hu.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
