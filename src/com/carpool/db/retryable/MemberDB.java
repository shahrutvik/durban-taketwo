package com.carpool.db.retryable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.carpool.util.DatabaseConnection;
import com.carpool.vo.MemberVO;

public class MemberDB {

	
		Connection connection=null;
		String table="`member`";
		String membergrouptable="`membergroups`";
		String columnIdMember="idmember";
		String columnFirstName="firstname";
		String columnLastName="lastname";
		String columnPhoneNumber="phonenumber";
		String columnIdMemberGroup="idMemberGroup";
		
		public void insert(MemberVO memberVO){
			
			try{
							
					connection=DatabaseConnection.connectToDatabase();
					Statement s = connection.createStatement();
					int count;
					String insertQuery="INSERT INTO "+table+"("+columnFirstName+","+columnLastName+","+columnPhoneNumber+")"
			               + " VALUES"
			               + "('" + memberVO.getFirstName() + "','" +  memberVO.getLastName() + "','" + memberVO.getPhoneNumber() +"')";
					count = s.executeUpdate (insertQuery);        
				    s.close ();
				    System.out.println (count + " members was inserted ");
			}
			catch(SQLException e){
				System.out.println("Failed to insert member record"  + e.getMessage());
			}
			finally{
				DatabaseConnection.closeConnection();
			}
		}

		public int getNumberOfMembers() {
			int numberOfMembers=0;
		try{
				
				connection=DatabaseConnection.connectToDatabase();
				Statement s = connection.createStatement();
				
				String selectQuery="SELECT COUNT(*) AS NUMOFMEMBERS FROM "+table;
		         
				ResultSet rs = s.executeQuery (selectQuery);
				rs.next();
				numberOfMembers=rs.getInt("NUMOFMEMBERS");
			    rs.close ();
			    System.out.println (numberOfMembers + " members in the table ");
		}
		catch(SQLException e){
			System.out.println("Failed to get member count:"  + e.getMessage());
		}
		finally{
			DatabaseConnection.closeConnection();
		}
		return numberOfMembers;
		}

		public int getMemberId(String memberPhoneNumber) {
			int memberId=0;
			try{
						
						
						connection=DatabaseConnection.connectToDatabase();
						
						Statement s = connection.createStatement();
						String selectQuery="SELECT "+columnIdMember+" as memberId FROM "+table
					               + " WHERE "
					               + columnPhoneNumber+"="+"'"+memberPhoneNumber+"'";   
						   
						   ResultSet rs = s.executeQuery (selectQuery);		               
						              
						   rs.next();
						   memberId = rs.getInt("memberId") ;
						   rs.close() ;
						   System.out.println("Member Id " + memberId + " returned");
						   s.close ();
						   
						   
					}
					catch(SQLException e){
						System.out.println("Failed to fetch member id"  + e.getMessage());
					}
					finally{
						DatabaseConnection.closeConnection();
					}
				return memberId;
					
		}
		
}


