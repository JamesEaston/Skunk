import java.util.*;
public class Client{
	//Declares a variable to assure the players want to play another round,
	//a score variable which will be the value of the roll, a scanner input
	//object, a temperary variable to store any necessary numbers, a 
	//play variable to assure that the round is still playable, and an array
	//to store the numbers which were rolled
	static boolean playRound;
	static String tempString;
	static int[] rolledNums = new int[2];
	static int score;
	static Scanner input = new Scanner(System.in);
	static int tempVariable;
	static Player[] players;
	static Dice dice;
	static boolean choice;
	static int winner;

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

		while(playRound && roundNum < 6){
			choice = true;

			if(roundNum == 1) {
				System.out.println("Round: S");
			}

			else if(roundNum == 2){
				System.out.println("Round: SK");
			}

			else if(roundNum == 3){
				System.out.println("Round: SKU");
			}

			else if(roundNum == 4){
				System.out.println("Round: SKUN");
			}

			else{
				System.out.println("Round: SKUNK");
			}

			while(choice){

				rolledNums = dice.roll();
				System.out.println(dice.toString(rolledNums[0]));
				System.out.print(dice.toString(rolledNums[1]));

				tempVariable = dice.checkEnd(rolledNums[0], rolledNums[1]);
				if (tempVariable > 0){
					if (tempVariable == 2){
						for (int i = 0; i < players.length; i++){
							if (players[i].getStanding()){
								players[i].resetScore();
							}
						}
					}
					choice = false;
					System.out.println("Round over!");
				}

				else{
					score += rolledNums[0] + rolledNums[1];
					for (int i = 0; i < players.length; i++){
						if(players[i].getStanding()){
							System.out.println("Would " + players[i].getName() + " like to stay standing? (return true or false)");
							players[i].setStanding(Boolean.parseBoolean(input.nextLine()));
							if(!players[i].getStanding()){
								players[i].addScore(score);
							}
						}
					}
					choice = validStanding();
				}
			}

			System.out.println(printScoreboard());
			if (roundNum < 5){
				System.out.println("Would you like to play another round? (Reply true or false)");
				playRound = Boolean.parseBoolean(input.nextLine());
			}

			roundNum++;
			score = 0;
			tempVariable = 0;

			for (int i = 0; i < players.length; i++){
				players[i].setStanding(true);
			}
		}

		winner = 0;
		for(int i = 1; i < players.length; i++){
			if(players[i].getScore() > players[winner].getScore()){
				winner = i;
			}
		}

		System.out.println(players[winner].getName() + " is the winner with a score of " + players[winner].getScore() + "!");

		System.out.println("Thanks for playing!");
	}

	public static boolean validStanding(){
		for(int i = 0; i < players.length; i++){
			if(players[i].getStanding()){
				return true;
			}
		}
		return false;
	}

	public static String printScoreboard(){
		String output = "";
		output += "-------------------------\n";
		for(int i = 0; i < players.length; i++){
			output += players[i].getName() + ": " + players[i].getScore();
			output += "\n";
		}
		output += "-------------------------\n";

		return output;
	}
}