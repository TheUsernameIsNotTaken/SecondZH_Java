//A jelenlegi gyakorló feladatsor feladata

//Progcont: https://progcont.hu/progcont/100355/?pid=201426

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Primvalogatas {
	public static void main(String[] args) {

		/*
		//A parancssori argumentumok miatt --> Insert try/catch
		File file = new File(args[0]);

		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/

		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()){
			//A sor beolvasása és darabolása
			String[] data = sc.nextLine().split(" ");

			//Lehetséges a tömböt Listaként feldolgozni, és azt Set-ként lementeni. -> DE EZ SZÖVEG!
			//Set<String> dataSet =  new HashSet<String>(Arrays.asList(data));

			//Leképzem az adatokat egy int listába a parseInt segítségével, és abból csinálok egy TreeSet-et.
			Set<Integer> dataSet  = Arrays.asList(data).stream().map(Integer::parseInt).collect(Collectors.toSet());
			Set<Integer> sortedDataSet = new TreeSet<>(dataSet);

			// Új lista a prímek tárolásásra
			ArrayList<Integer> primes = new ArrayList<>();
			//Bejárás
			for(int number : sortedDataSet){
				//Prímellenőrzés
				if(IsPrime.intNumber(number))
					primes.add(number);
			}
			//Kiíratás, ha van prím
			if(primes.size() >= 1){
				boolean first = true;			//Egy flag-et használok az első adat jelzésére.
				for(int number : primes){		//Bejárás
					if(first){
						first = false;			//Az elsőnél a Flag-et kiütöm.
					}else{
						System.out.print(", ");	//Amúgy el kell választanom a következő elemet.
					}
					System.out.print(number);	//Szám kiírása.
				}
				System.out.println();			//Üres sor a végére
			}
			//NOTHING, ha nincs prím.
			else{
				System.out.println("NOTHING");
			}
		}
	}
}

//Prím ellenőrző segédosztály.
class IsPrime{
	/**
	 * Megmondja, hogy x prím szám-e.
	 * @param x int típusú szám, amit ellenőrzök
	 * @return boolean - Prím-e x
	 */
	public static boolean intNumber(int x){
		if(x < 2){
			return false;
		}
		if(x == 2){
			return true;
		}
		if (x % 2 == 0) {
			return false;
		}
		int sqrt = (int)Math.sqrt(x)+1;
		for(int i = 3; i < sqrt; i++){
			if(x % i == 0){
				return false;
			}
		}
		return true;
	}
}