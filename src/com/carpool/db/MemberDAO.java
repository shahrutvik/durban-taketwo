package com.carpool.db;

import com.carpool.db.retryable.MemberDB;
import com.carpool.vo.MemberVO;

public class MemberDAO {

	MemberDB memberVirtual;

	public MemberDAO(){
		memberVirtual = new MemberDB();
	}
	
	public void insertMember(MemberVO member) {
		memberVirtual.insert(member);
	}

	public int getNumberOfMembers() {
		return memberVirtual.getNumberOfMembers();
		
	}

	public int getMemberId(String memberPhoneNumber) {
		return memberVirtual.getMemberId(memberPhoneNumber);
	}

}
