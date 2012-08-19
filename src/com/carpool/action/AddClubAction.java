package com.carpool.action;

import com.carpool.db.ClubDAO;
import com.carpool.vo.ClubVO;


public class AddClubAction {
	
	ClubDAO clubDAO;
	
	public AddClubAction(){
		clubDAO = new ClubDAO();
	}
	
	public void add(String clubName){
		ClubVO club = new ClubVO();
		club.setClubName(clubName);
		
		add(club);
	}
	
	private void add(ClubVO club){
		 clubDAO.insertClub(club);
	}

}
