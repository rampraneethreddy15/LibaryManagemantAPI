package libgenesis.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import libgenesis.models.genres;

public interface genresRepo extends JpaRepository<genres, UUID>{
	
	@Query(value = "select * from genres ge where ge.genre_name=:genreName", nativeQuery = true)
	genres getGenreId(String genreName);
	
	
	
}
