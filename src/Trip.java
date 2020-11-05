//Feladatok a múltból - 1

//Progcont: https://progcont.hu/progcont/100219/?pid=201103

import java.util.*;

public class Trip {

    //Az adatokat tároló osztály - Ez összehasonlítható magával.
    private static class Data implements Comparable<Data>{

        private String name;
        private int km;

        /**
         * Alt+Insert-tel generált alap konstruktor
         * @param name A túra neve.
         * @param km A túra hossza.
         */
        public Data(String name, int km) {
            this.name = name;
            this.km = km;
        }

        /**
         * Összehasonlítás - Mikor egyenlő 2 túraútvonal?
         * @param o A másik túraútvonal, amihez hasonlítom
         * @return A CompareTo működésének megfelelő visszatérési értékek.
         */
        @Override
        public int compareTo(Data o) {
            int res = Integer.compare(o.km,km);
            if (res != 0){
                return res;
            }
            return name.compareTo(o.name);
        }

        /**
         * A túra szövegként.
         * @return A túra neve.
         */
        @Override
        public String toString() {
            return name;
        }
    }
    public static void main(String[] args) {

        //Rendezett Map-ot használunk
        Map<String, Set<Data>> map = new TreeMap<>();

        //Sorok beolvasása
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            //Az adatokat ;-el tagolom
            String[] datas = sc.nextLine().split(";");
            //Az összes adatot fel akarom dolgozni
            for (int i = 1; i < datas.length; i++) {
                //Egy adatot :-el splitelem magán belül.
                String[] tripkm = datas[i].split(":");
                //Halmaz a Táblázat értéke. - Ezt megfelelően bővítem vagy hozom létre.
                Set<Data> value = map.get(tripkm[0]);
                if (value == null) {
                    value = new TreeSet<>();
                    map.put(tripkm[0], value);
                }
                value.add(new Data(datas[0], Integer.parseInt(tripkm[1])));
            }
        }
        //Kiíratáshoz egy StringJoiner segítségét használom.
        for (Map.Entry<String, Set<Data>> entry : map.entrySet()) {
            StringJoiner sj = new StringJoiner(", ");
            for (Data item : entry.getValue()) {
                sj.add(item.toString());
            }
            System.out.println(entry.getKey() + " (" + entry.getValue().size() + "): "+sj.toString());
        }
    }
}
