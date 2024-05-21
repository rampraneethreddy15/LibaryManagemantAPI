package libgenesis.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import libgenesis.models.transactions;

@Repository
public interface transactionsRepo extends JpaRepository<transactions, UUID>{

	@Query(value = "select * from transactions where bookId=:bookId", nativeQuery = true)
	List<transactions> findTransactionsByBookId(UUID bookId);
	
	@Query(value = "select * from transactions where memberId=:memberId", nativeQuery = true)
	List<transactions> findTransactionsByMemberId(UUID memberId);

}
