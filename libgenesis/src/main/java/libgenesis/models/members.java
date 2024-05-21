package libgenesis.models;

import jakarta.persistence.Entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class members {
	
	@Id
	private UUID memberId;
	private String name;
	private String address;
	private long phoneNo;
	private String email;
	private Timestamp memberFrom;
	
	public UUID getMemberId() {
		return memberId;
	}
	public void setMemberId(UUID memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getMemberFrom() {
		return memberFrom;
	}
	public void setMemberFrom(Timestamp memberFrom) {
		this.memberFrom = memberFrom;
	}
	
	public members(String name, UUID memberId, long phoneNo, String address, String email, Timestamp memberFrom) {
		this.name = name;
		this.memberId = memberId;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.memberFrom = memberFrom;
	}
	@Override
	public String toString() {
		return "members [memberId=" + memberId + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", memberFrom=" + memberFrom + "]";
	}
	public members() {
		super();
	}
	

}
