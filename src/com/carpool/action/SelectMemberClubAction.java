package com.carpool.action;

import com.carpool.db.MemberToClubDAO;

public class SelectMemberClubAction {
	
	MemberToClubDAO memberToClubDAO; 
	
	public SelectMemberClubAction(){
		memberToClubDAO = new MemberToClubDAO();
	}
	
	public String getClubName(String memberPhoneNumber){
		return memberToClubDAO.getClubName(memberPhoneNumber);
	}

}
