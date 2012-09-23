package com.carpool.util;

import java.util.Random;

public class RandomWordPair {
	
	String words[]={"awesome","welcome","razor","gully","sweater","sky","earth"};
	
	public RandomWordPair(){
		
	}
	
	public String getRandomWordPair(String prefix){
		Random rand = new Random();
		int n=rand.nextInt( words.length);
		String secret=words[n];
		return(prefix+"-"+n+"-"+secret);

	}

}
