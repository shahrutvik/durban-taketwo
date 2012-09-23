package com.carpool.db.retryable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.carpool.util.DatabaseConnection;
import com.carpool.vo.ClubVO;

public class ClubDB {

	
		Connection connection=null;
		String table="`club`";
		String membergrouptable="`membergroups`";
		String columnIdClub="idclub";
		String columnName="name";
		String columnIdMemberGroup="idMemberGroup";
		
		public void insert(ClubVO clubVO){
			
			try{
							
					connection=DatabaseConnection.connectToDatabase();
					Statement s = connection.createStatement();
					int count;
					String insertQuery="INSERT INTO "+table+"("+columnName+")"
			               + " VALUES"
			               + "('" + clubVO.getClubName() +"')";
					count = s.executeUpdate (insertQuery);        
				    s.close ();
				    System.out.println (count + " club was inserted ");
			}
			catch(SQLException e){
				System.out.println("Failed to insert club record"  + e.getMessage());
			}
			finally{
				DatabaseConnection.closeConnection();
			}
		}

		public int getNumberOfClubs() {
			int numberOfClubs=0;
		try{
				
				connection=DatabaseConnection.connectToDatabase();
				Statement s = connection.createStatement();
				
				String selectQuery="SELECT COUNT(*) AS NUMOFCLUBS FROM "+table;
		         
				ResultSet rs = s.executeQuery (selectQuery);
				rs.next();
				numberOfClubs=rs.getInt("NUMOFCLUBS");
			    rs.close ();
			    System.out.println (numberOfClubs + " clubs in the table ");
		}
		catch(SQLException e){
			System.out.println("Failed to get club count:"  + e.getMessage());
		}
		finally{
			DatabaseConnection.closeConnection();
		}
		return numberOfClubs;
		}

		public int getIdForNickname(String clubName) {
			int idClub = 0;
			try{
				
				connection=DatabaseConnection.connectToDatabase();
				Statement s = connection.createStatement();
				
				String selectQuery="SELECT idClub AS IDCLUB" +
						" FROM "+
						table+
						"where "+columnName+"='"+clubName+"'";
		        System.out.println("getIdForNickName: "+selectQuery); 
				ResultSet rs = s.executeQuery (selectQuery);
				rs.next();
				idClub=rs.getInt("IDCLUB");
			    rs.close ();
			    System.out.println ("Club Id: "+idClub);
		}
		catch(SQLException e){
			System.out.println("Failed to get club id:"  + e.getMessage());
		}
		finally{
			DatabaseConnection.closeConnection();
		}
		return idClub;
		}

		public boolean exists(ClubVO club) {
			boolean clubExists=false;
try{
				
				connection=DatabaseConnection.connectToDatabase();
				Statement s = connection.createStatement();
				
				String selectQuery="SELECT COUNT(*) AS NUMCLUBS" +
						" FROM "+
						table+
						" where "+columnName+"='"+club.getClubName()+"'";
		        System.out.println("exists: "+selectQuery); 
				ResultSet rs = s.executeQuery (selectQuery);
				rs.next();
				int numberOfClubs=rs.getInt("NUMCLUBS");
			    rs.close ();
			    System.out.println ("Number Of Clubs: "+numberOfClubs);
			    if(numberOfClubs==1){
			    	clubExists=true;
			    }
		}
		catch(SQLException e){
			System.out.println("Failed to get club count:"  + e.getMessage());
		}
	finally{
		DatabaseConnection.closeConnection();
	}
	return clubExists;
	}
		
}


