package Codes;

import java.util.Scanner;

public class script1 {

	//deck-arrays
	static final int deckSize = 52;
	static int [] number = new int [deckSize];
	static char [] suit = new char [deckSize];
	
	
	//deal-arrays
	static int handSize = 5;
	static int [] pNumber = new int [handSize];
	static int [] cNumber = new int [handSize];
	static char [] pSuit = new char [handSize];
	static char [] cSuit = new char [handSize];
	
	static int counter = 0;
    static int pCounter = 0;
    static int cCounter = 0;
	
    
    
    //deal for player
	public static void pDeal(int pCurrentHand)
	{
		for(int x = 0; x < pCurrentHand; x++)
		{
			//deal deck for player
			pNumber[pCounter] = number[counter];
			pSuit[pCounter] = suit[counter];			
			
			pCounter++;
			counter++;
			
		}
	
	}

	
	
	
	//deal for computer
	public static void cDeal(int cCurrentHand)
	{

		for(int x = 0; x < cCurrentHand; x++)
		{
		//deal deck for computer
		cNumber[cCounter] = number[counter];
		cSuit[cCounter] = suit[counter];
		
		cCounter++;
		counter++;
		}
	
	}
	
	
	//deal to both player and computer
	public static int dealAll(int allCurrentHand)
	{
		for(int x = 0; x < allCurrentHand; x++)
		{
		
			//deal deck for player
			pNumber[pCounter] = number[counter];
			pSuit[pCounter] = suit[counter];			
			
			pCounter++;
			counter++;	
			
			
	    //deal deck for computer
		cNumber[cCounter] = number[counter];
		cSuit[cCounter] = suit[counter];
		
		cCounter++;
		counter++;
		}
		return allCurrentHand;
	}
	
	
	
	
	
	
	public static void deck()
	{
		for(int x = 0; x < deckSize; x++)
		{
			//generate numbers sequentially from 1 to 13 four times
			number[x] = x % 13 + 1;
		    
			//if statements to match x value with suit
			if(x <= 12)
			{
				suit[x] = 'S';
			}
			else if (x >= 13 && x <= 25)
			{
				suit[x] = 'H';
			}
			else if (x >= 26 && x <= 38)
			{
				suit[x] = 'C';
			}
			else if (x >= 39 && x <= 51)
			{
				suit[x] = 'D';
			}
		
		}
		
	}


	public static void print(int[] num, char[] suit, int arraySIZE)
	{
	
            for(int index = 0; index < arraySIZE; index++)
		{   
            
			if(num[index] < 11 && num[index] > 1) 
			System.out.print(num[index] + "\t");
			//Print face cards
			else if(num[index] == 11) 
			System.out.print("J\t");
			else if(num[index] == 12)
				System.out.print("Q\t");
			else if(num[index] == 13)
				System.out.print("K\t");
			else if(num[index] == 1)
				System.out.print("A\t");
		}
			System.out.println();
		// Print out the corresponding suit of the card
		for(int index = 0; index < arraySIZE; index++)
			System.out.print(suit[index] + "\t");
}
	

	public static void shuffleDeck()
	{
		//loop 52 times   	 
	  	for(int x = 0; x < deckSize; x++)
		{ 
        //random number for array
	  	int randomShuffle = (int) (Math.random() * deckSize);
        
	  	//store original array as temporary
		int temp = number[x];
        //set original array to random array 
		number[x] = number[randomShuffle];
        //set random array to the older array	  	
		number[randomShuffle] = temp;
	
		//store original array as temporary
		temp = suit[x];
		//set original array to random array 
		suit[x] = suit[randomShuffle];
		//set random array to the older array  	
		suit[randomShuffle] = (char) temp;
		
		}
	}
	
	
	public static int handSum( int [] hand, int sumCount)
	{
		int handValue = 0;
		int aceCount = 0;
		
		for(int x = 0; x < sumCount; x++)
		{
		    //add 10 is the card is a face card
			if(hand[x] > 10)
			{
			  handValue += 10;
			}
			//if the card is an ace then add 1 or 11 depending on if the hand value goes above 21
			else if(hand[x] == 1)
			{
			handValue += 11;
		    aceCount++;
			}
			else
			{
			handValue += hand[x];
			}
		}
		
		while(aceCount > 0 && handValue > 21)
		{			
			handValue -= 10;	
			aceCount--;
		}
		
    return handValue;
		
	}	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
		int again = 0;
		int wins = 0;
	    int loses = 0;
		
	    //populate deck
	    deck();

	    
	    
	 //loop as long as playAgain is 1  
	 do{
	 
	
	    //reset counters
	     counter = 0;
         pCounter = 0;
         cCounter = 0;	
	
	    int selection = 0;	
	    
		
		//shuffle deck and deal 2 cards
	    shuffleDeck();
		dealAll(2);
		
		System.out.println();
		
		//calculate sum by calling handSum method
		int pHandValue = handSum(pNumber, pCounter);    
		int cHandValue = handSum(cNumber, cCounter);
		
		
		//print cards
		System.out.println("Player: ");
		print(pNumber,pSuit, pCounter);
		System.out.println();
		System.out.println();
        System.out.println("Player Sum: " + pHandValue + "\n");
		
		System.out.println("\nDealer: ");
		print(cNumber, cSuit,1);
		System.out.println();
	    
		
		
		
		
		// loop until selection is 0
	do{
			
		
		
		System.out.println();
		System.out.println("1. Hit");
		System.out.println("2. Stand\n");
		
		
		
		//input selection
		System.out.print(">> ");
		selection = input.nextInt();
		System.out.println();
			    
			
		//---------------------------hit
			if(selection == 1)
	    {           
				
				System.out.println();
		
				
                //deal 1 card
				pDeal(1);
			    
				//calculate sum again
				pHandValue = handSum(pNumber, pCounter);    
				
				// print player card
				System.out.println("Player: ");
				print(pNumber,pSuit, pCounter);
				System.out.println();
				System.out.println();
		        System.out.println("Player Sum: " + pHandValue + "\n");
		      
				// print dealer card
				System.out.println("\nDealer: ");
				print(cNumber, cSuit,1);
				System.out.println();
				
				
			// if sum is greater than 21 then player loses
		    if(pHandValue > 21)
		    {
			System.out.println();
		    System.out.println("You Lose! Your hand value is greater than 21.");
			loses++;
		    break;
		    }
		    
		    //if the player has 5 cards then they win
			else if(pCounter > 4)
		    {
			System.out.println();
			System.out.println("You Win! You have 5 cards.");
			wins++;
			break;
		    }
		
		    
	    }
		
			
			//------------------------------Stand
			else if(selection == 2)
			{
			  //exits the selection loop
			  selection = 0;
			  
			  //deal 1 card to computer is the sum is less then 17
			  while(cHandValue < 17)
			  {
				
				  cDeal(1);
				  
				  //calculate sum 
				  cHandValue = handSum(cNumber, cCounter);
				  
				  //print cards
				  System.out.println("Player: ");
				  print(pNumber,pSuit, pCounter);
				  System.out.println();
				  System.out.println();
			      System.out.println("Player Sum: " + pHandValue + "\n");
					
				  System.out.println("\nDealer: ");
				  print(cNumber, cSuit, cCounter);
				  System.out.println();
				  System.out.println("Dealer Sum: " + cHandValue + "\n");
				  
				  
				  //if computer sum is greater than 21 then player wins
				  if(cHandValue > 21)
				{
				System.out.println();
			    System.out.println("You Win! The dealers hand value is greater than 21.");
				wins++;
				break;
			    }
				//if dealer has 5 cards then player loses
				else if(cCounter > 4)
				{
				System.out.println("Player: ");
				print(pNumber,pSuit, pCounter);
			    System.out.println();
				System.out.println();
				System.out.println("Player Sum: " + pHandValue + "\n");
						
			    System.out.println("\nDealer: ");
				print(cNumber, cSuit, cCounter);
				System.out.println();
				System.out.println("Dealer Sum: " + cHandValue + "\n");
					
				System.out.println();
					
				System.out.println("You Lose! The dealer has 5 cards!");
				loses++;
				break;
				}
		      
			  }
			 
			  //if the computer sum is between 17 and 21 inclusive
			  if(cHandValue >= 17 && cHandValue <= 21)
			  {
				  
				  //if player and computer sum is equal
				  if(pHandValue == cHandValue)
				  {
					  System.out.println("It is a Tie! The dealer has the same hand value as you.");
				  }
				  //player hand value is greater than computer hand value then player wins
				  else if(pHandValue > cHandValue)
				  {
					  System.out.println("You win! You have a greater hand value than the dealer.");
				      wins++;
				  
				  }
				  //player hand value is less than computer hand value then player wins
				  else if(pHandValue < cHandValue)
				  {
					  System.out.println("Player: ");
						print(pNumber,pSuit, pCounter);
					    System.out.println();
						System.out.println();
						System.out.println("Player Sum: " + pHandValue + "\n");
								
					    System.out.println("\nDealer: ");
						print(cNumber, cSuit, cCounter);
						System.out.println();
						System.out.println("Dealer Sum: " + cHandValue + "\n");
							
						System.out.println();
						
					  System.out.println("You Lose! The dealer has a higher hand value.");
				      loses++;
				  }
			  }
			  
			}
	
	}while(selection != 0);

	//print stats
    System.out.println();
	System.out.println("You won: " + wins);
	System.out.println("You lost: " + loses);
	System.out.println();
	
	//play again prompt
	System.out.println("Press 1 to play again.");
	System.out.print(">> ");
	again = input.nextInt();
	System.out.println();


}while(again == 1);
	
	}

}