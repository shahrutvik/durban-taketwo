package com.carpool.db.retryable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.carpool.util.DatabaseConnection;
import com.carpool.vo.MemberToClubVO;

public class MemberClubsDB {
	Connection connection=null;
	String table="`memberclubs`";
	String memberTable="`member`";
	String clubTable="`club`";
	//String columnIdMemberGroup="idMemberGroup";
	String columnIdMember="idmember";
	String columnIdClub="idclub";
	String columnName="name";
	String columnPhoneNumber="phonenumber";
	
	public void insert(MemberToClubVO memberToGroupVO){
		
		
		try{
			
			
			connection=DatabaseConnection.connectToDatabase();
					
			Statement s = connection.createStatement();
			   int count;
			   String insertQuery="INSERT INTO "+table+"("+columnIdMember+","+columnIdClub+")"
		               + " VALUES"
		               + "('" + memberToGroupVO.getMemberId() + "','" +  memberToGroupVO.getClubId() + "')";
			   count = s.executeUpdate (insertQuery);              
			             
			   
			   s.close ();
			   
			   System.out.println (count + " rows were inserted");
		}
		catch(SQLException e){
			System.out.println("Failed to insert member in a club record"  + e.getMessage());
		}
		finally{
		DatabaseConnection.closeConnection();
		}
	}

	public String getClubName(String memberPhoneNumber) {
		String clubName=null;
		try{
									
					connection=DatabaseConnection.connectToDatabase();
					
					Statement s = connection.createStatement();
					String selectQuery="SELECT "+columnName+" as CLUBNAME FROM "+table+" mc INNER JOIN"+memberTable+" m INNER JOIN"+clubTable+" c"
				               + " WHERE "
				               + "mc."+columnIdClub+"="+"c."+columnIdClub
				               + " AND "
				               + "mc."+columnIdMember+"="+"m."+columnIdMember
							   + " AND "
							   + "m."+columnPhoneNumber+"="+"'"+memberPhoneNumber+"'";
					 System.out.println(selectQuery);  
					   ResultSet rs = s.executeQuery (selectQuery);		               
					              
					   rs.next();
					   clubName = rs.getString("CLUBNAME") ;
					   rs.close() ;
					   System.out.println("Club Name " + clubName + " returned");
					   s.close ();
					   
					   
				}
				catch(SQLException e){
					System.out.println("Failed to fetch club name"  + e.getMessage());
				}
				finally{
					DatabaseConnection.closeConnection();
				}
			return clubName;
	}
	

}
