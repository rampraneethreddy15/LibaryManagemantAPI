package libgenesis.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import libgenesis.models.authors;
import libgenesis.models.publishers;

public interface authorsRepo extends JpaRepository<authors, UUID>{
	
	@Query(value = "select * from authors au where au.author_name=:authorName", nativeQuery = true)
	authors getAuthorId(String authorName);

}
