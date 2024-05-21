package libgenesis.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libgenesis.models.members;
import libgenesis.repos.authorsRepo;
import libgenesis.repos.booksRepo;
import libgenesis.repos.booksauthorsRepo;
import libgenesis.repos.genresRepo;
import libgenesis.repos.membersRepo;
import libgenesis.repos.publishersRepo;
import libgenesis.repos.transactionsRepo;

@Service
public class membersservice {

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
	
//	@Autowired
//	public membersservice(membersRepo MR) {
//	    this.MR = MR;
//	}

	
	
	public Object addMember(members member) {
		
		
		Timestamp memberFrom = new Timestamp(new Date().getTime());
		UUID memberId = UUID.randomUUID();
		member.setMemberId(memberId);
		member.setMemberFrom(memberFrom);
		System.out.println(member);
		MR.save(member);
		return member;
	}
	
	
	public List<members> getMembers(){
		
		List<members> list = MR.findAll();
		List<members> lis = new ArrayList<>();
		for (members member:list) {
			members m = new members(member.getName(), member.getMemberId(), member.getPhoneNo(), member.getAddress(), member.getEmail(), member.getMemberFrom());
			lis.add(m);
		}
		return lis;
	}

}
