package libgenesis.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import libgenesis.models.bookdetails;
import libgenesis.models.books;
import libgenesis.models.members;
import libgenesis.models.transactionRequest;
import libgenesis.models.transactions;
import libgenesis.responses.booksdetails;
import libgenesis.services.booksservice;
import libgenesis.services.membersservice;
import libgenesis.services.transactionsservice;

@RestController
@RequestMapping("libgenesis")
public class bookscontroller {
	
	@Autowired
	booksservice booksservice;
	@GetMapping("books")
	public List<booksdetails> getBooks(){
		return booksservice.getBooks();
	}
	
	@PostMapping("books")
	public Object addBook(@RequestBody books bs) {
		
		return booksservice.addBook(bs);
		
	}
	
	@GetMapping("books/genres")
	public List<books> getBooksByGenre(@RequestParam UUID genreId){
		 return booksservice.getBooksByGenre(genreId);
	}
	
	@GetMapping("books/authors")
	public List<books> getBooksByAuthor(@RequestParam String authorName){
		return booksservice.getBooksByAuthor(authorName);
	}
	
	@DeleteMapping("books")
	public Object deletebooks() {
		return booksservice.deleteBooks();
	}
	
	
	@Autowired
	membersservice membersservice;
	@PostMapping("members")
	public Object addMember(@RequestBody members member) {
		
		
		return membersservice.addMember(member);
		
	}
	
	@GetMapping("members")
	public List<members> getMembers() {
		
		
		return membersservice.getMembers();
		
	}
	
	
	@Autowired
	transactionsservice transactionsservice;
	@PostMapping("transactions")
	public Object newTransaction(@RequestBody transactionRequest trans) {
		
		return transactionsservice.newTransaction(trans);
	}
	
	@GetMapping("transactions/books")
	public List<transactions> getTransactionsByBookId(@RequestParam UUID bookId){
		return transactionsservice.getTransactionsByBookId(bookId);
	}
	
	@GetMapping("transactions")
	public List<transactions> getTransactions(){
		return transactionsservice.getTransactions();
	}
	
	@GetMapping("transactions/members")
	public List<transactions> getTransactionsByMemberId(@RequestParam UUID memberId){
		return transactionsservice.getTransactionsByBookId(memberId);
	}

}
