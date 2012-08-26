package com.carpool.action;

import com.carpool.db.ClubDAO;
import com.carpool.db.MemberDAO;
import com.carpool.db.MemberToClubDAO;
import com.carpool.vo.MemberToClubVO;


public class AddMemberToClubAction {
	
	MemberToClubDAO membertoClubDAO;
	ClubDAO clubDAO;
	MemberDAO memberDAO;
	//MemberTokenDAO memberTokenDAO;
	
	public AddMemberToClubAction(){
		membertoClubDAO = new MemberToClubDAO();
		clubDAO = new ClubDAO();
		memberDAO = new MemberDAO();
		//memberTokenDAO = new MemberTokenDAO();
	}
	
	public void add(String clubName,String memberPhoneNumber){
		//adds the member to the Club and initializes the token record.
		MemberToClubVO memberToClub = new MemberToClubVO();
		//MemberTokenVO memberToken= new MemberTokenVO();
		int clubId=clubDAO.getClubId(clubName);
		int memberId=memberDAO.getMemberId(memberPhoneNumber);
		if(clubId!=0 && memberId!=0){
			memberToClub.setClubId(clubId);
			memberToClub.setMemberId(memberId);
			add(memberToClub);
			//Also add a initial token record for this member
			/*
			int memberClubId=membertoClubDAO.getMemberClubId(memberToClub);
			if(memberClubId!=-1){
				memberToken.setMemberClubId(memberClubId);
				memberToken.setTotalToken(0);
				memberTokenDAO.insertMemberTokenRecord(memberToken);
			}
			else
			{
				System.out.println("Failed to initialize member token");
			}*/
			
		}
		else{
			System.out.println("Failed to add member to the Club");
		}
		
	}

	/*public void add(int memberId,int ClubId){
		
		MemberToClubVO memberToClub = new MemberToClubVO();
		memberToClub.setMemberId(memberId);
		memberToClub.setClubId(ClubId);
		add(memberToClub);
	}*/
	
	private void add(MemberToClubVO memberToClub){
		membertoClubDAO.insertMemberToClubRecord(memberToClub);
		//memberTokenDAO.insertMemberTokenRecord(memberToClub);
	}

	
	

}
