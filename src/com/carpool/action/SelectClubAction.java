package com.carpool.action;

import com.carpool.db.ClubDAO;


public class SelectClubAction {
	
	int numberOfClubs=0;
	ClubDAO clubDAO;
	
	public SelectClubAction(){
		clubDAO = new ClubDAO();
	}
	
	protected int getNumberOfClubs(){
			return clubDAO.getNumberOfClubs();
	}
	
	
	
}
