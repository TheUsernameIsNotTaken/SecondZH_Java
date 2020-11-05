//Könnyű Extra feladatok - 2

//Progcont: https://progcont.hu/progcont/100231/?pid=201149

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Katica {
	public static void main(String[] args) {
		//Beolvasás
		Scanner sc = new Scanner(System.in);
		//Lista
		List<Pair> pairs = new ArrayList<>();
		//Minden adat kiszámolása.
		while(sc.hasNextLine()){
			String[] data = sc.nextLine().split(" ");
			pairs.add(new Pair(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
		}
		//Eredmények kiírása.
		for(Pair item : pairs){
			System.out.println(item.toString());
		}
	}
}

// Segédosztály
class Pair{
	int two, seven;

	/**
	 * Létrehoz egy Pair-t. Itt párokat keresek egy problémában heads és dots adatok segítségével.
	 * @param heads Fejek száma.
	 * @param dots Pöttyök száma.
	 */
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

	/**
	 *
	 * @return A kettő és hét pettyes katicák száma.
	 */
	@Override
	public String toString() {	return two + " " + seven;	}
}