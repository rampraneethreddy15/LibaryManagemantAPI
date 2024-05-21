package libgenesis.models;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class transactions {
	
	@Id
	private UUID transactionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
	private books book;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_Id")
	private members member;
	
	private String transactionType;
	@Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
	
	public transactions(UUID transactionId, books book, members member, String transactionType, Timestamp returnDate) {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.transactionType = transactionType;
        this.returnDate = returnDate;
    }
	
    public transactions(UUID transactionId, UUID bookId, UUID memberId, String transactionType,
			Timestamp returnDate) {
		this.transactionId = transactionId;
		this.book.setBookId(bookId);
		this.member.setMemberId(memberId);
		this.transactionType = transactionType;
		this.returnDate = returnDate;
    }

	@PrePersist
    protected void onCreate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        this.dueDate = cal.getTime();
    }
    
    private Timestamp returnDate;

	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	public books getBook() {
		return book;
	}

	public void setBook(books book) {
		this.book = book;
	}

	public members getMember() {
		return member;
	}

	public void setMember(members member) {
		this.member = member;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}
	

	public transactions() {
		super();
	}
	
	
	
}
