//Könnyű Extra feladatok - 1

//Progcont: https://progcont.hu/progcont/100277/?pid=201282

import java.util.Scanner;

/**
 * The Class, which contains the main, and implements the problem's solution with the help of the KamiLYon class.
 */
public class Tankolasok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Read the first line and get all the data out from it.
        String s = sc.nextLine();
        String[] sa = s.split(" ");
        //Create a new Obj.
        KamiLYon kam = new KamiLYon(Integer.parseInt(sa[0]),
                                    Integer.parseInt(sa[1]),
                                    Integer.parseInt(sa[2]),
                                    Integer.parseInt(sa[3]) );
        int n = kam.getTankolasok();
        //Read in every refuel and store&use only the necessary data.
        for(int i = 0; i < n; i++){
            String tmp = sc.nextLine();
            String[] data = tmp.split(" ");
            kam.addBenzin(Integer.parseInt(data[1]));
        }
        //Write out the remaining petrol.
        System.out.println(kam.maradekBenzin());
    }
}

/**
 * The Class, which helps to document all the stops and the remaining gasoline in the tank.
 */
class KamiLYon{
    private int ut;
    private int benzin;
    private int tankolasok;
    private int fogyasztas;

    /**
     * Creates a KamiLYon object, which stores all the needed information to solve the problem.
     * @param ut The whole length of the road (in kilometers).
     * @param benzin The starting gasoline in the tank (in liters).
     * @param tankolasok The number of stops, where we refueled.
     * @param fogyasztas The Truck's petrol consumption in one kilometer.
     */
    public KamiLYon(int ut, int benzin, int tankolasok, int fogyasztas) {
        this.ut = ut;
        this.benzin = benzin;
        this.tankolasok = tankolasok;
        this.fogyasztas = fogyasztas;
    }

    /**
     * Refuel the tank with benzin.
     * @param benzin The number of liters which we fueled up.
     */
    public void addBenzin(int benzin) {
        this.benzin = this.benzin + benzin;
    }

    /**
     * Returns the number of stops, where we refueled.
     * @return The tankolasok private integer.
     */
    public int getTankolasok() {
        return tankolasok;
    }

    /**
     * Returns the remaining liters of gasoline after the road.
     * @return All the gasoline minus the overall fuel usage during the trip (benzin-(ut*fogyasztas)) as an integer.
     */
    public int maradekBenzin() {
        return benzin - (ut*fogyasztas);
    }
}