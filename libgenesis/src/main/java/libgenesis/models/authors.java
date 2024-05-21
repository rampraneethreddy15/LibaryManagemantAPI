package libgenesis.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class authors {
	
	@Id
	private UUID authorId;
	
	
	private String authorName;


	public UUID getAuthorId() {
		return authorId;
	}

	public void setAuthorId(UUID authorId) {
		this.authorId = authorId;
	}

	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public authors(UUID authorId) {
		this.authorId = authorId;
	}
	
	public authors() {
		
	}

	public authors(UUID authorId, String authorName) {
		this.authorId = authorId;
		this.authorName = authorName;
	}


}
