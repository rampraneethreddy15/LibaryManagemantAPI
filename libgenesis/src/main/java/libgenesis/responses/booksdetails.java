package libgenesis.responses;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import libgenesis.models.authors;
import libgenesis.models.genres;
import libgenesis.models.publishers;

public class booksdetails {
	
	private UUID bookId;
	private String title;
	private String author;
	private String edition;
	private String isbn;
	private genres genreId;
	private String genreName;
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	private String publisherName;
	private long publicationYear;
	private UUID publicationId;
	private int quantity;
	public UUID getBookId() {
		return bookId;
	}
	public void setBookId(UUID bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public genres getGenreId() {
		return genreId;
	}
	public void setGenreId(genres genreId) {
		this.genreId = genreId;
	}
	
	public booksdetails(UUID bookId, String title, String author, String edition, String isbn, String genreName,
			String publisherName, long publicationYear, UUID publicationId, int quantity) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.isbn = isbn;
		this.genreName = genreName;
		this.publisherName = publisherName;
		this.publicationYear = publicationYear;
		this.publicationId = publicationId;
		this.quantity = quantity;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public long getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(long publicationYear) {
		this.publicationYear = publicationYear;
	}
	public UUID getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(UUID publicationId) {
		this.publicationId = publicationId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
