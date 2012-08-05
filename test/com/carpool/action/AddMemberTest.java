package com.carpool.action;

import org.testng.annotations.Test;
import org.testng.Assert;



public class AddMemberTest {
  @Test
  public void addNewMemberToDatabase() {
	  
	  SelectMemberAction selectMemberAction = new SelectMemberAction();
	  int numberOfMembers=selectMemberAction.getNumberOfMembers();
	  AddMemberAction addMemberAction = new AddMemberAction();
	  addMemberAction.add("Rutvik", "Shah","123-456-7890");
	  int afterAddingMember=selectMemberAction.getNumberOfMembers();
	  Assert.assertEquals(afterAddingMember,numberOfMembers+1);
	  
	  
  }
  
  public void cannotAddSameMemberTwice(){
	  
  }
  public void displayErrorWhenWrongPhoneNumber(){
	  
  }
  
}
