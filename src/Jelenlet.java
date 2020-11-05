//Feladatok a múltból - 2

//Progcont: https://progcont.hu/progcont/100231/?pid=201147

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class City{
    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name.toLowerCase();
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + " (" + population + ')';
    }
}

public class Jelenlet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Első sor beolvasásása
        String[] data0 = sc.nextLine().split(" ");
        int n = Integer.parseInt(data0[0]);
        String city = data0[1];
        int maxPopultion = -1;
        List<City> cities = new ArrayList<City>();
        // For ciklus n-szer.
        for(int i = 0; i < n; i++){
            //Város és lakossága
            String[] data = sc.nextLine().split(":");
            cities.add(new City(data[0], Integer.parseInt(data[1])));
            //A keresett város lakosságának elmentése
            if( data[0].equals(city) )
                maxPopultion = Integer.parseInt(data[1]);
        }
        final int finalMaxPopulation = maxPopultion;
        //Hianyzo adat jelzése.
        if(finalMaxPopulation < 0){
            System.out.println("Missing data");
        }
        //Normál esetben szűrök, rendezek és kiíratok.
        else{
            List<City> smallerCities = new ArrayList<City>(cities
                    .stream()
                    .filter(c -> c.getPopulation() < finalMaxPopulation)
                    .collect(Collectors.toList())
            );
            smallerCities.sort(Comparator
                    .comparing(City::getPopulation, Comparator.reverseOrder())
                    .thenComparing(City::getName, Comparator.reverseOrder())
            );
            for(City item : smallerCities){
                System.out.println(item.toString());
            }
        }
    }
}
