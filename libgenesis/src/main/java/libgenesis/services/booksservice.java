package libgenesis.services;

import java.lang.reflect.Field;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import libgenesis.responses.Exceptionresponse;
import libgenesis.IdGenerator;
import libgenesis.models.authors;
import libgenesis.models.bookdetails;
import libgenesis.models.books;
import libgenesis.models.booksauthors;
import libgenesis.models.genres;
import libgenesis.models.publishers;
import libgenesis.repos.*;
import libgenesis.responses.booksdetails;

@Service
public class booksservice {
	
	@Autowired
	booksRepo BR;
	
	@Autowired
	authorsRepo AR;
	
	@Autowired
	booksauthorsRepo BAR;
	
	@Autowired
	genresRepo GR;
	
	@Autowired
	membersRepo MR;
	
	@Autowired
	publishersRepo PR;
	
	@Autowired
	transactionsRepo TR;
	
	private UUID generateNewId() {
	    return UUID.randomUUID();
	}
	
	public List<booksdetails> getBooks(){
		List<books> list = BR.findAll();
		List<booksdetails> BDlist = new ArrayList<>();
		for(books book:list) {
//			booksauthors ba = BAR.findByBookId(book.getBookId());
			Optional<genres> ge = GR.findById(book.getGenres().getGenreId());
			booksdetails bd = new booksdetails(book.getBookId(),book.getTitle(), book.getAuthor().getAuthorName(), book.getEdition(), book.getIsbn(),ge.get().getGenreName(), book.getPublisher().getPublisherName(), book.getPublicationYear() , book.getPublisher().getPublicationId(), book.getQuantity());
			BDlist.add(bd);
		}
		return BDlist;
	}
	
	
	public Object addBook(books bs) {
		
		books bs1 = bs;
//		Field[] fields=bs.getClass().getDeclaredFields();
//        for(Field f:fields){
//            try {
//                f.setAccessible(true);
//                Object value=f.get(bs);
//                if(value==null){
//                    return new Exceptionresponse("must enter complete details","HCT400");
//                }
//                System.out.println(value);
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }
		System.out.println(bs);
        UUID bookId = generateNewId();
        
        UUID genreId = generateNewId();
        
        UUID publicationId = generateNewId();
        
        UUID authorId = generateNewId();
        
        genres genre = GR.getGenreId(bs.getGenres().getGenreName());
        if (genre == null) {
        	
        	bs.getGenres().setGenreId(genreId);
        	
        }
        else {
        	genres gen = new genres(genre.getGenreId(), bs.getGenres().getGenreName());
        	bs.setGenres(gen);
        }
        
        publishers publisher = PR.getPublisherId(bs.getPublisher().getPublisherName());
        if (publisher == null) {
        	
        	bs.getPublisher().setPublisherId(publicationId);
        }
        else {
        	publishers pub = new publishers(publisher.getPublicationId(), bs.getPublisher().getPublisherName());
        	bs.setPublisher(pub);
        }
        
        authors author = AR.getAuthorId(bs.getAuthor().getAuthorName());
        if (author == null) {
        	
        	bs.getAuthor().setAuthorId(authorId);
        }
        else {
        	authors aut = new authors(author.getAuthorId(), bs.getAuthor().getAuthorName());
        	bs.setAuthor(aut);
        }
//        books b = new books(bookId, bookds.getTitle(), bookds.getAuthor() , bookds.getEdition(), bookds.getIsbn(), bookds.getPublicationYear(), bookds.getQuantity());
//        publishers p = new publishers(publicationId, bookds.getPublisherName());
//        genres g = new genres(genreId, bookds.getGenreName());
//        authors a = new authors(authorId);
//        BR.save(b);
//        PR.save(p);
//        GR.save(g);
//        AR.save(a);
        bs.setBookId(bookId);
        
        
        
        
        books b = BR.save(bs);
        if (b != null) {
            return b;
        } else {
            return new Exceptionresponse("Failed to save book", "HCT500");
        }
        //return new booksdetails(b.getTitle(), b.getAuthor(), b.getEdition(), b.getIsbn(),g.getGenreName(), p.getPublisherName(), b.getPublicationYear(), p.getPublicationId(), b.getQuantity());
	}

	public List<books> getBooksByGenre(UUID genreId) {
		
		return BR.findBooksByGenreId(genreId);
	}
	
	public List<books> getBooksByAuthor(String authorName){
		return BR.findBooksByAuthorId(authorName);
	}
	
	public Object deleteBooks() {
		BR.deleteAll();
		return "delete successful";
	}

}
