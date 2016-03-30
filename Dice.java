import java.util.*;

public class Dice{
	private Random rand = new Random();
	private int[] rolled = new int[2];

	public Dice(){
	}

	public int[] roll(){
		rolled[0] = rand.nextInt(6);
		rolled[1] = rand.nextInt(6);
		return rolled;
	}

	public String toString(int die){
		String output = "";
		if(die == 1){
			output += "------------\n";
			output += "|           |\n";
			output += "|           |\n";
			output += "|     *     |\n";
			output += "|           |\n";
			output += "|           |\n";
			output += "------------\n";
		}
		if(die == 2){
			output += "------------\n";
			output += "|           |\n";
			output += "|   *       |\n";
			output += "|           |\n";
			output += "|        *  |\n";
			output += "|           |\n";
			output += "------------\n";
		}
		if(die == 3){
			output += "------------\n";
			output += "|           |\n";
			output += "|  *        |\n";
			output += "|     *     |\n";
			output += "|        *  |\n";
			output += "|           |\n";
			output += "------------\n";
		}
		if(die == 4){
			output += "------------\n";
			output += "|           |\n";
			output += "|   *    *  |\n";
			output += "|           |\n";
			output += "|   *    *  |\n";
			output += "|           |\n";
			output += "------------\n";
		}
		if(die == 5){
			output += "------------\n";
			output += "|           |\n";
			output += "|  *     *  |\n";
			output += "|     *     |\n";
			output += "|  *     *  |\n";
			output += "|           |\n";
			output += "------------\n";
		}
		if(die == 6){
			output += "------------\n";
			output += "|           |\n";
			output += "|  *     *  |\n";
			output += "|  *     *  |\n";
			output += "|  *     *  |\n";
			output += "|           |\n";
			output += "------------\n";
		}
		
		return output;
	}

	public static int checkEnd(int num1, int num2){
		if(((num1 + num2) % 6 == 2) && ((num1 + num2) > 6)) {
			return 1;
		}

		if(((num1 + num2) % 5 == 3) && ((num1 + num2) > 5)) {
			return 1;
		}

		if((num1 + num2 == 2)) {
			return 2;
		}
		
		return 0;
	}
}