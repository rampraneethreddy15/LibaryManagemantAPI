package libgenesis.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class genres {
	
	@Id
	private UUID genreId;
	
	private String genreName;

	

	public UUID getGenreId() {
		return genreId;
	}

	public void setGenreId(UUID genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	public genres(UUID genreId, String genreName) {
		
		this.genreId = genreId;
		this.genreName = genreName;
		
	}
	
	public genres() {
		
	}

}
