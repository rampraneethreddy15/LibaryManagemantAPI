package libgenesis.models;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class books {
	
	@Id
	private UUID bookId;
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorName", referencedColumnName = "authorName")
	private authors author;
	private String edition;
	private String isbn;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId", referencedColumnName = "genreId")
	private genres genres;
	
	
	private long publicationYear;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publicationId", referencedColumnName = "publicationId")
	private publishers publisher;
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
	public genres getGenres() {
		return genres;
	}
	public void setGenres(genres genres) {
		this.genres = genres;
	}
	public publishers getPublisher() {
		return publisher;
	}
	public void setPublisher(publishers publisher) {
		this.publisher = publisher;
	}
	public authors getAuthor() {
		return author;
	}
	public void setAuthor(authors author) {
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
	public long getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(long publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public books(UUID bookId, String title, authors author, String edition, String isbn, long publicationYear, int quantity) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.quantity = quantity;
	}
	public books() {
		
	}
	@Override
	public String toString() {
		return "books [bookId=" + bookId + ", title=" + title + ", author=" + author + ", edition=" + edition
				+ ", isbn=" + isbn + ", genres=" + genres + ", publicationYear=" + publicationYear + ", publisher="
				+ publisher + ", quantity=" + quantity + "]";
	}
	
	
	

}
