package com.carpool.action;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.carpool.util.RandomWordPair;



public class AddClubTest {
	RandomWordPair randomWordPair;
	
  public AddClubTest(){
	  randomWordPair=new RandomWordPair();
	  
  }
  @Test
  public void addNewClubToDatabase() {
	  
	  SelectClubAction selectClubAction = new SelectClubAction();
	  int numberOfclubs=selectClubAction.getNumberOfClubs();
	  AddClubAction addclubAction = new AddClubAction();
	  addclubAction.add(randomWordPair.getRandomWordPair("club"));
	  int afterAddingclub=selectClubAction.getNumberOfClubs();
	  Assert.assertEquals(afterAddingclub,numberOfclubs+1);
	    
  }
  
  @Test
  public void cannotAddSameClubNameTwice(){
	  
	  SelectClubAction selectClubAction = new SelectClubAction();
	  int numberOfclubs=selectClubAction.getNumberOfClubs();
	  AddClubAction addclubAction = new AddClubAction();
	  String clubName=randomWordPair.getRandomWordPair("club");
	  addclubAction.add(clubName);
	  int afterAddingclub=selectClubAction.getNumberOfClubs();
	  Assert.assertEquals(afterAddingclub,numberOfclubs+1);
	  addclubAction.add(clubName);
	  int afterAddingSecondclub=selectClubAction.getNumberOfClubs();
	  Assert.assertEquals(afterAddingSecondclub,numberOfclubs+1);
 
  }
  
  public void cannotAddBlankClubName(){
	  
  }
  
  
  
}
