
public class Player {
	//Declares a score and standing variable for the player
	private int score;
	private boolean standing;
	private String name;

	//Constructor for the player, sets the score to 0 and standing to true
	public Player(String pName){
		score = 0;
		standing = true;
		name = pName;
	}

	//Increments score by the indicated amount
	public void addScore(int n) {
		score += n;
	}

	//Resets score to 0
	public void resetScore() {
		score = 0;
	}

	//Returns the score of the player
	public int getScore() {
		return score;
	}

	//Returns whether the player is standing or not
	public boolean getStanding() {
		return standing;
	}

	//Sets the player to standing or sitting
	public void setStanding(boolean position) {
		standing = position;
	}

	public String getName(){
		return name;
	}
}