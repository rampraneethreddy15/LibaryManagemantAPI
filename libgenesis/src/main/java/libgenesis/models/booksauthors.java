package libgenesis.models;

import jakarta.persistence.*;

@Entity
@Table(name = "booksauthors")
public class booksauthors {
	
	@Id
	private long id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private books bookId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId", referencedColumnName = "authorId")
	private authors authorId;


}
