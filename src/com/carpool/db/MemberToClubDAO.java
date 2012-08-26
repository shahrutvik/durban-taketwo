package com.carpool.db;

import com.carpool.db.retryable.MemberClubsDB;
import com.carpool.vo.MemberToClubVO;

public class MemberToClubDAO {
	
	MemberClubsDB memberToClubVirtual;

	public MemberToClubDAO(){
		memberToClubVirtual = new MemberClubsDB();
	}
	
	public void insertMemberToClubRecord(MemberToClubVO memberToClubVO){
		memberToClubVirtual.insert(memberToClubVO);
	}

	public String getClubName(String memberPhoneNumber) {
		return memberToClubVirtual.getClubName(memberPhoneNumber);
	}

}
