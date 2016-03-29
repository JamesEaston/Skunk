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
}