package libgenesis.services;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libgenesis.models.books;
import libgenesis.models.members;
import libgenesis.models.transactionRequest;
import libgenesis.models.transactions;
import libgenesis.repos.authorsRepo;
import libgenesis.repos.booksRepo;
import libgenesis.repos.booksauthorsRepo;
import libgenesis.repos.genresRepo;
import libgenesis.repos.membersRepo;
import libgenesis.repos.publishersRepo;
import libgenesis.repos.transactionsRepo;

@Service
public class transactionsservice {
	
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
	
	public Object newTransaction(transactionRequest trans) {
		
		System.out.println(trans);
		Timestamp returnDate = new Timestamp(new Date().getTime());
		Optional<books> bookO = BR.findById(trans.getBookId());
		Optional<members> memberO = MR.findById(trans.getMemberId());
		System.out.println(trans);
		if (bookO.isPresent() && memberO.isPresent()) {
	        books b = bookO.get();
	        members m = memberO.get();
			int quantity = b.getQuantity();
			String transactionType = trans.getTransactionType();
			System.out.println(trans);
			System.out.println(b);
			
			
			if (transactionType.equals("borrow") && quantity > 0) {
				UUID transactionId = UUID.randomUUID();
				System.out.println(trans);
				transactions transaction = new transactions(transactionId, bookO.get(), memberO.get(), trans.getTransactionType(), returnDate);
				System.out.println(trans);
				TR.save(transaction);
				quantity -= 1;
				b.setQuantity(quantity);
				System.out.println(trans);
				BR.save(b);
				return transaction;
			}
			else {
				UUID transactionId = UUID.randomUUID();
				transactions transaction = new transactions(transactionId, bookO.get(), memberO.get(), trans.getTransactionType(), returnDate);
				TR.save(transaction);
				quantity += 1;
				b.setQuantity(quantity);
				BR.save(b);
				System.out.println(trans);
				return transaction;
			}
		

		}
		else {
	        // Handle case where book or member is not found
	        return new Exception("Book or Member not found");
	    }
	}
	
	
	public List<transactions> getTransactions(){
		return TR.findAll();
	}
	
	public List<transactions> getTransactionsByBookId(UUID bookId){
		return TR.findTransactionsByBookId(bookId);
	}
	
	public List<transactions> getTransactionsByMemberId(UUID memberId){
		return TR.findTransactionsByBookId(memberId);
	}
	

}
