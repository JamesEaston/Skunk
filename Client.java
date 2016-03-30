import java.util.*;
public class Client{
	//Declares a variable to assure the players want to play another round,
	//a score variable which will be the value of the roll, a scanner input
	//object, a temperary variable to store any necessary numbers, a 
	//play variable to assure that the round is still playable, and an array
	//to store the numbers which were rolled
	static boolean playRound;
	static boolean play;
	static int[] rolledNums = new int[2];
	static int score;
	static Scanner input = new Scanner(System.in);
	static int tempVariable;
	static Player[] players;

	public static void main(String[] args) {
		//Sets playRound to true by default
		playRound = true;
		
		//Takes in how many players are desired and constructs
		//that many player objects, which are stored in the array "players"
		System.out.println("How many players would like to play?");
		tempVariable = Integer.parseInt(input.nextLine());
		players = new Player[tempVariable];
		for(int i = 0; i < tempVariable; i++){
			System.out.println("Player: " + (i + 1) + " what is your name?");
			players[i] = new Player(input.nextLine());
		}
		
		while(playRound){
			play = true;

			while (play){
			}

			System.out.println("Would you like to play another round? (Reply true or false)");
			playRound = Boolean.parseBoolean(input.nextLine());
		}
	}

	public static boolean validStanding(){
		for(int i = 0; i < players.length; i++){
			if(players[i].getStanding()){
				return false;
			}
		}
		return true;
	}
}