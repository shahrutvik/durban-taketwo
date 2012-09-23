package com.carpool.action;

import java.util.ArrayList;

import com.carpool.db.MemberToClubDAO;

public class SelectMemberClubAction {
	
	MemberToClubDAO memberToClubDAO; 
	
	public SelectMemberClubAction(){
		memberToClubDAO = new MemberToClubDAO();
	}
	
	public ArrayList<String> getClubName(String memberPhoneNumber){
		return memberToClubDAO.getClubName(memberPhoneNumber);
	}

}
