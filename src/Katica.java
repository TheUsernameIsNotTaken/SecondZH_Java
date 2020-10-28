//Könnyű Extra feladatok - 2

//Progcont: https://progcont.hu/progcont/100231/?pid=201149

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Katica {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Pair> pairs = new ArrayList<>();
		while(sc.hasNextLine()){
			String[] data = sc.nextLine().split(" ");
			pairs.add(new Pair(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
		}
		for(Pair item : pairs){
			System.out.println(item.toString());
		}
	}
}

class Pair{
	int two, seven;

	public Pair(int heads, int dots) {
		seven = dots / 7;
		int remains = dots % 7;
		if(remains % 2 != 0) {
			seven--;
			remains += 7;
		}
		two = remains / 2;
		while(two+seven < heads){
			seven -= 2;
			two += 7;
		}
	}

	@Override
	public String toString() {	return two + " " + seven;	}
}