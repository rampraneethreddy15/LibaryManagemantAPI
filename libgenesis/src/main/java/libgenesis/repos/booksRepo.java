package libgenesis.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import libgenesis.models.books;
import libgenesis.responses.booksdetails;

public interface booksRepo extends JpaRepository<books, UUID>{
	
	@Query(value = "select * from books where genre_id=:genreId", nativeQuery = true)
	List<books> findBooksByGenreId(UUID genreId);
	
	@Query(value = "select * from books where author_name=:authorName", nativeQuery = true)
	List<books> findBooksByAuthorId(String authorName);

}
