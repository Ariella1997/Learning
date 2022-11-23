import java.util.Scanner;
import java.util.Random ;

public class KnotCrosses {


    String a ;
	int b = 0 ;
	int c ;
	int d ;
	String[][] b1 = new String[4][4] ;
	Scanner s1 = new Scanner(System.in) ;
	Random r1 = new Random() ;
	
	
	void MainMenu() {
		System.out.println("");
		System.out.println("Tic Tac Toe");
		System.out.println("P - Play");
		System.out.println("H - Help");
		System.out.println("Q - Quit");
		a = s1.nextLine();
		MainMenuOption(a);
	}
	
	void MainMenuOption(String a) {
		switch(a.toUpperCase()) {
		case "P": DifficultyMenu() ;
		break ;
		case "H": HelpMenu() ;
		break ; 
		case "Q": System.out.println("Quitting");
		System.exit(0); 
		break ;
		default: System.out.println("Please select again");
		MainMenu() ; 
		}
		
	}
	
	void HelpMenu() {
		System.out.println("Help");
		System.out.println("Insert the Co-ordinate into the log");
		System.out.println("Try to get 3 in a row, diagonal or a column");
		System.out.println("Press any key to continue");
		a = s1.nextLine();
		MainMenu() ;
		
	}
	
	void DifficultyMenu(){
		System.out.println("Please select the desired difficulty");
		System.out.println("E - Easy");
		// System.out.println("H - Hard");
		System.out.println("B - Back");
		a = s1.nextLine();
		DifficultyOption(a) ;
		
	}
	
	// Will work on adding a hard difficulty that will base their action on what I have done later. 
	// For now, the computer move will only be for an easy computer, that randomly chooses a place
	
	void DifficultyOption(String a) {
		switch(a.toUpperCase()) {
		case "E": System.out.println("Starting Game");
		StartingBoard(b1) ;
		break ;
		// case "H": System.out.println("Starting Game");
		// StartingBoard(b1) ;
		// break ;
		case "B" : MainMenu() ;
		default: System.out.println("Please select again");
		DifficultyMenu() ;
		
		}
		
	}
	
	void StartingBoard(String[][] b1){
		b1[1][1] = " " ; 
		b1[1][2] = " " ; 
		b1[1][3] = " " ; 
		b1[2][1] = " " ; 
		b1[2][2] = " " ; 
		b1[2][3] = " " ; 
		b1[3][1] = " " ; 
		b1[3][2] = " " ; 
		b1[3][3] = " " ; 
		b = r1.nextInt(2) ;
		DisplayBoard(b1 , b) ;
	}
	
	void DisplayBoard(String[][] b1, int b){
		System.out.println("");
		System.out.println(" " + "|" + "1" + "|" + "2" + "|" + "3" + "|" );
		System.out.println("1" + "|" + b1[1][1] + "|" + b1[1][2] + "|" + b1[1][3] + "|");
		System.out.println("2" + "|" + b1[2][1] + "|" + b1[2][2] + "|" + b1[2][3] + "|");
		System.out.println("3" + "|" + b1[3][1] + "|" + b1[3][2] + "|" + b1[3][3] + "|");
		if(VictoryCheck(b1) == 1 ){
			if(b % 2 == 0) {
				System.out.println("");
				System.out.println("Congratulations, you've won!!");
				s1.nextLine() ;
				MainMenu() ;
			}
			else {
				System.out.println("Hahaha, I've won!!");
				System.out.println("");
				s1.nextLine() ;
				MainMenu() ;
			}
		}
		if(DrawCheck(b1) == 1 ) {
			System.out.println("");
			System.out.println("Game is a draw");
			s1.nextLine() ;
			MainMenu();
		}
		b++ ; 
		if(b % 2 == 0) {
			System.out.println("");
			System.out.println("It is your turn");
			YourMove( b1 , b) ;
		}
		else {
			System.out.println("");
			System.out.println("Computer is thinking...");
			ComputerMove(b1 , b) ;
		}
		
		}
	
	void YourMove(String[][] b1 , int b) {
		System.out.println("Please select a row");
		try{ 
			c = s1.nextInt();
		}
		catch(Exception e) {
			System.out.println("Please input a valid row");
			System.out.println("");
			s1.nextLine() ;
			YourMove(b1 , b) ;
		}
		System.out.println("Please select a column");
		try{ 
			d = s1.nextInt() ;
		}
		catch(Exception e) {
			System.out.println("Something went wrong, try again");
			System.out.println("");
			s1.nextLine() ;
			YourMove(b1 , b) ;
		}
		try{
			if( b1[c][d] == " ") {
				b1[c][d] = "x" ;
				DisplayBoard(b1 , b) ; 
		}
			else {
				System.out.println("Occupied Square, try again");
				YourMove(b1 , b) ;
		}
		} catch(Exception e) {
			System.out.println("Something went wrong, try again");
			System.out.println("");
			YourMove( b1 , b) ;
		}
	}
	
	void ComputerMove( String[][] b1 , int b) {
		c = 1 + r1.nextInt(3) ; 
		d = 1 + r1.nextInt(3) ; 
		if(b1[c][d] == " ") {
			b1[c][d] = "o" ;
			DisplayBoard(b1 , b) ; 
		}
		else {
			ComputerMove(b1 , b) ;
		}
	}
	
	int VictoryCheck(String[][] b1) {
		if( b1[1][1] == b1[2][2] && b1[1][1] == b1[3][3] && b1[1][1] != " ") {
			return 1 ;
			}
		if( b1[3][1] == b1[2][2] && b1[3][1] == b1[1][3] && b1[3][1] != " ") {
			return 1 ;
			}
		if( b1[1][1] == b1[1][2] && b1[1][1] == b1[1][3] && b1[1][1] != " ") {
			return 1 ;
			}
		if( b1[2][1] == b1[2][2] && b1[2][1] == b1[2][3] && b1[2][1] != " ") {
			return 1 ;
			}
		if( b1[3][1] == b1[3][2] && b1[3][1] == b1[3][3] && b1[3][1] != " ") {
			return 1 ;
			}
		if( b1[1][1] == b1[2][1] && b1[1][1] == b1[3][1] && b1[1][1] != " ") {
			return 1 ; 
			}
		if( b1[1][2] == b1[2][2] && b1[1][2] == b1[3][2] && b1[1][2] != " ") {
			return 1 ; 
			}
		if( b1[1][3] == b1[2][3] && b1[1][3] == b1[3][3] && b1[1][3] != " ") {
			return 1 ; 
			}
		else {
			return 0 ;
		}
	}
	
	int DrawCheck(String[][] b1){
		for(int i = 0 ; i < 4 ; i++ ){
			for(int j = 0 ; j < 4 ; j++) {
				if(b1[i][j] == " ")
					return 0 ;
				}
			}
		return 1 ;
	}



    
}
