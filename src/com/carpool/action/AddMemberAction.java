package com.carpool.action;

import com.carpool.db.MemberDAO;
import com.carpool.vo.MemberVO;

public class AddMemberAction {
	
	MemberDAO memberDAO;
	
	public AddMemberAction(){
		memberDAO = new MemberDAO();
	}
	
	public void add(String firstName,String lastName,String phoneNumber){
		MemberVO member = new MemberVO();
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setPhoneNumber(phoneNumber);
		add(member);
	}
	
	private void add(MemberVO member){
		 memberDAO.insertMember(member);
	}

}
