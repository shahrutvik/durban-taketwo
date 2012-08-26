package com.carpool.action;

import org.testng.annotations.Test;
import org.testng.Assert;



public class AddMemberToClubTest {
  @Test
  public void addMemberToClubInDatabase() {
	  
	  String memberFirstName="Rutvik";
	  String memberLastName="Shah";
	  String memberPhoneNumber="123-456-7893";
	  String clubName="awesome";
	  
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
	  Assert.assertEquals(selectMemberClubAction.getClubName(memberPhoneNumber),clubName);
	  
	  
  }
  
  public void canAddMembersToMultipleClubs(){
	  
  }
  
  public void canAddMoreThanOneMembersToOneClub(){
	  
  }
  
  
  
  
}
