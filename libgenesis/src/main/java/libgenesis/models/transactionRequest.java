package libgenesis.models;

import java.util.UUID;

public class transactionRequest {
	
	private UUID bookId;
	
	private UUID memberId;
	
	private String transactionType;

	

	public UUID getBookId() {
		return bookId;
	}

	public void setBookId(UUID bookId) {
		this.bookId = bookId;
	}

	public UUID getMemberId() {
		return memberId;
	}

	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "transactionRequest [bookId=" + bookId + ", memberId=" + memberId + ", transactionType="
				+ transactionType + "]";
	}
	
	
}
