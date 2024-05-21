package libgenesis.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import libgenesis.models.publishers;

public interface publishersRepo extends JpaRepository<publishers, UUID>{
	
	@Query(value = "select * from publishers pu where pu.publisher_name=:publisherName", nativeQuery = true)
	publishers getPublisherId(String publisherName);

}
