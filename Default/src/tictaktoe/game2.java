package tictaktoe;

import java.util.Scanner;

//Git Test

public class game2 {
	public static void main(String[] args){
		
		// variable section
		String playerInput;
		int[] inputList;
		int count=2;
		boolean tie=false;

		// Draw initial board : call class
		initialBoard();
		
		
		// initialize input list
		inputList = new int[9];
		for (int i=0; i<9; i++){
			inputList[i]=0;
		}
		
		/*
		 * Get user input
		 */
		Scanner y = new Scanner (System.in);
		while (checkIfWinner(inputList)==false){ //keep going till there is a winner
			// check for player 1 or player2 turn
			if (count%2 ==0){
				System.out.println("Player 1 please provide cell number..");
			}
			else{
				System.out.println("Player 2 please provide cell number..");
			}
			
			playerInput = y.next();
			/*
			 * check if the user input is valid
			 */
			if (isValidInput(inputList, playerInput)) {
				inputList= markUserInput(inputList, Integer.parseInt(playerInput),count);
				drawBoard(inputList);
			}
			if (count==10) { // if number of inputs is 11 between both player its a tie
				tie=true;
				break;
			}
			count++;
		}
		if (tie==true){
			System.out.println(" Its a Tie");
		}
		else if (tie==false && count%2!=0){
			System.out.println(" Player 1 Wins!");
		}
		else if (tie==false && count%2 ==0){
			System.out.println(" Player 2 Wins!");
		}
		y.close();
	}
	
	private static boolean isValidInput(int inputList[], String index){
		/*
		 * This module will check if the input is valid
		 *  1) input between 1 & 9
		 *  2) place is empty
		 */
		int asciiValue=0;
		boolean isValid;
		
		try{
			asciiValue= (int) Integer.parseInt(index);
			if (asciiValue < 1 || asciiValue > 9)
			{
				isValid=false;
				System.out.println("Your input is not between 1 & 9");
			} else
			{
				isValid=true;
			}
		} 
		catch (Exception e){
			isValid=false;
			System.out.println("Your input is not between 1 & 9");
		}
		
		if (isValid && inputList[asciiValue-1] !=0){
			isValid=false;
			System.out.println("This place is taken.. try agian");
		}
		return isValid;
	}
	
	private static int[] markUserInput(int x[], int index, int count){
		/*
		 * This module will mark the user input on the grid 
		 */
		if (count%2 ==0){	
			x[index-1]=1;}
		else{
			x[index-1]=2;
		}
		return x;
	}

	private static boolean checkIfWinner (int x[]){
		boolean win = false;
		
	// checking for winning combo				
	if( x[0]!=0 && x[0] == x[1] && x[0] == x[2] || //top row
		x[3]!=0 && x[3] == x[4] && x[3] == x[5] || //middle row
		x[6]!=0 && x[6] == x[7] && x[6] == x[8] || //bottom row
		x[0]!=0 && x[0] == x[3] && x[0] == x[6] || //first column
		x[1]!=0 && x[1] == x[4] && x[1] == x[7] || //second column
		x[2]!=0 && x[2] == x[5] && x[2] == x[8] || //third column
		x[0]!=0 && x[0] == x[4] && x[0] == x[8] || //first diagonal
		x[2]!=0 && x[2] == x[4] && x[2] == x[6] )  //second diagonal
	{
		win=true;
	}
	return win;	
	}
	
	private static void drawBoard(int x[]){
		String[] displayList; //for display only
		
		displayList = new String[9];
		for (int i=0; i<9; i++){
			if (x[i]==1){
				displayList[i]=" X ";  //if player1 then put X'
			}
			else if(x[i]==2){
				displayList[i]=" O "; //if player 2 then put O
			}
			else{
				displayList[i]="   "; // if still 0 then put blank
			}
		}
		
		System.out.println("   " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + "  ");
		System.out.println(displayList[0] +"|"+ displayList[1] +"|"+ displayList[2]);
		System.out.println(" - + - + -");
		System.out.println(displayList[3] +"|"+ displayList[4] +"|"+ displayList[5]);
		System.out.println(" - + - + -");
		System.out.println(displayList[6] +"|"+ displayList[7] +"|"+ displayList[8]);
		System.out.println(" * " + " * " + " * " );
		System.out.println("");
	}
	
	private static void initialBoard(){
		System.out.println("   " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + "  ") ;
		System.out.println("1 | 2 | 3");
		System.out.println(" - + - + -");
		System.out.println("4 | 5 | 6");
		System.out.println(" - + - + -");
		System.out.println("7 | 8 | 9");
		System.out.println(" * " + " * " + " * " );
		System.out.println("");
	}	

}