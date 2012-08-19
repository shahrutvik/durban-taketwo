package com.carpool.db;

import com.carpool.db.retryable.ClubDB;
import com.carpool.db.retryable.MemberDB;
import com.carpool.vo.ClubVO;


public class ClubDAO {

	ClubDB clubVirtual;

	public ClubDAO(){
		clubVirtual = new ClubDB();
	}
	
	public void insertClub(ClubVO club) {
		clubVirtual.insert(club);
	}

	public int getNumberOfClubs() {
		return clubVirtual.getNumberOfClubs();
		
	}

}
