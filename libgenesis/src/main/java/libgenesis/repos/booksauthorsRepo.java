package libgenesis.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import libgenesis.models.booksauthors;

public interface booksauthorsRepo extends JpaRepository<booksauthors, Long>{
	
	@Query(value = "select * from booksauthors ba where ba.book_id=:bookId", nativeQuery = true)
	booksauthors findByBookId(long bookId);

}
