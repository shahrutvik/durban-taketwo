package com.carpool.action;

import com.carpool.db.MemberDAO;

public class SelectMemberAction {
	
	int numberOfMembers=0;
	MemberDAO memberDAO;
	
	public SelectMemberAction(){
		memberDAO = new MemberDAO();
	}
	
	protected int getNumberOfMembers(){
			return memberDAO.getNumberOfMembers();
	}
}
