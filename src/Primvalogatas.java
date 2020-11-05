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
			String[] data = sc.nextLine().split(" ");
			//Set<String> dataSet =  new HashSet<String>(Arrays.asList(data));
			Set<Integer> dataSet  = Arrays.asList(data).stream().map(Integer::parseInt).collect(Collectors.toSet());
			Set<Integer> sortedDataSet = new TreeSet<>(dataSet);
			ArrayList<Integer> primes = new ArrayList<>();
			for(int number : sortedDataSet){
				if(IsPrime.intNumber(number))
					primes.add(number);
			}
			if(primes.size() >= 1){
				boolean first = true;
				for(int number : primes){
					if(first){
						first = false;
					}else{
						System.out.print(", ");
					}
					System.out.print(number);
				}
				System.out.println();
			}else{
				System.out.println("NOTHING");
			}
		}
	}
}

class IsPrime{
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