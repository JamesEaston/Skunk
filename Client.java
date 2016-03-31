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
	static Dice dice;
	static boolean choice;

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
		dice = new Dice();
		
		int roundNum = 1;

		while(playRound & roundNum < 6){
			play = true;
			choice = true;

			if(roundNum == 1) {
				System.out.println("Round: S");
			}

			if(roundNum == 2){
				System.out.println("Round: SK");
			}

			if(roundNum == 3){
				System.out.println("Round: SKU");
			}

			if(roundNum == 4){
				System.out.println("Round: SKUN");
			}

			if(roundNum == 5){
				System.out.println("Round: SKUNK");
			}


			while (play){
				while(choice){
					rolledNums = dice.roll();
					System.out.println(dice.toString(rolledNums[0]));
					System.out.println(dice.toString(rolledNums[1]));
					tempVariable = dice.checkEnd(rolledNums[0], rolledNums[1]);
					//add a if statement to make sure it checks the check end
					System.out.println("Would you like to roll again? (Reply true or false)");
					choice = Boolean.parseBoolean(input.nextLine());
					if(choice == false){
						play = false;
					}
				}
			}

			System.out.println("Would you like to play another round? (Reply true or false)");
			playRound = Boolean.parseBoolean(input.nextLine());
			//Eventually print out ScoreBoard here instead of Game over.
			if(playRound == false){
				System.out.println("Game Over");
			} else {
				roundNum++;
			}
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