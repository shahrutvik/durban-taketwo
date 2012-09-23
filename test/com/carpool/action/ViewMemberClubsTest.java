package com.carpool.action;

import org.testng.annotations.Test;
import org.testng.Assert;



public class ViewMemberClubsTest {
  @Test
  public void viewMemberClubs() {
	  
	  String memberFirstName="Shrujal";
	  String memberLastName="Shah";
	  String memberPhoneNumber="123-456-7894";
	  String clubName="welcome";
	  String clubName2="welcome2";
	  
	  SelectMemberAction selectMemberAction = new SelectMemberAction();
	  int numberOfMembers=selectMemberAction.getNumberOfMembers();
	  AddMemberAction addMemberAction = new AddMemberAction();
	  addMemberAction.add(memberFirstName, memberLastName,memberPhoneNumber);
	  int afterAddingMember=selectMemberAction.getNumberOfMembers();
	  Assert.assertEquals(afterAddingMember,numberOfMembers+1);
	  
	  SelectClubAction selectClubAction = new SelectClubAction();
	  int numberOfclubs=selectClubAction.getNumberOfClubs();
	  AddClubAction addclubAction = new AddClubAction();
	  addclubAction.add(clubName);
	  int afterAddingclub=selectClubAction.getNumberOfClubs();
	  Assert.assertEquals(afterAddingclub,numberOfclubs+1);
	  
	  AddMemberToClubAction addMemberToClubAction = new AddMemberToClubAction();
	  addMemberToClubAction.add(clubName, memberPhoneNumber);
	  SelectMemberClubAction selectMemberClubAction= new SelectMemberClubAction();
	  //Assert.assertEquals(selectMemberClubAction.getClubName(memberPhoneNumber),clubName);
	  
	  //Adding member to another club
	  
	  addMemberToClubAction.add(clubName2, memberPhoneNumber);
	 // Assert.assertEquals(selectMemberClubAction.getClubName(memberPhoneNumber),clubName2);
	  
	  Assert.assertEquals(selectMemberClubAction.getClubName(memberPhoneNumber).size(),2);
	  Assert.assertEquals(selectMemberClubAction.getClubName(memberPhoneNumber).contains(clubName),true);
	  Assert.assertEquals(selectMemberClubAction.getClubName(memberPhoneNumber).contains(clubName2),true);
	  
	  
	  
	  
  }
  
  public void cannotAddSameClubNameTwice(){
	  
  }
  
  public void cannotAddBlankClubName(){
	  
  }
  
  
  
}
