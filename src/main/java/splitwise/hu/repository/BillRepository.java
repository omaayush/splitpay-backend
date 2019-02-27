package splitwise.hu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import splitwise.hu.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
}
