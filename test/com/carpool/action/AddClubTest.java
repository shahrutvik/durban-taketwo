package com.carpool.action;

import org.testng.annotations.Test;
import org.testng.Assert;



public class AddClubTest {
  @Test
  public void addNewClubToDatabase() {
	  
	  SelectClubAction selectClubAction = new SelectClubAction();
	  int numberOfclubs=selectClubAction.getNumberOfClubs();
	  AddClubAction addclubAction = new AddClubAction();
	  addclubAction.add("awesome");
	  int afterAddingclub=selectClubAction.getNumberOfClubs();
	  Assert.assertEquals(afterAddingclub,numberOfclubs+1);
	  
	  
  }
  
  public void cannotAddSameClubNameTwice(){
	  
  }
  public void displayErrorWhenWrongPhoneNumber(){
	  
  }
  public void cannotAddBlankClubName(){
	  
  }
  
  
  
}
