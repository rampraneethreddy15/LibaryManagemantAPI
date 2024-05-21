package libgenesis.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class publishers {
	
	@Id
	private UUID publicationId;
	
	private String publisherName;

	
	public UUID getPublicationId() {
		return publicationId;
	}

	public void setPublisherId(UUID publicationId) {
		this.publicationId = publicationId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	public publishers(UUID publicationId, String publisherName) {
		this.publicationId = publicationId;
		this.publisherName = publisherName;
	}
	
	public publishers() {
		
	}


}
