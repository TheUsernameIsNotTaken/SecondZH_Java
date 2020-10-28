//Nehezebb Extra feladat
//Ugyanez a C#-os gyűjteményben is benne van. Ott dupla táblázatot használunk, itt saját osztályú listát.
//Saját osztály készítése esetén sokszot egy lista is elég, ámbár ez bonyolít(hat)ja a feladatot, és általában növeli a kódolási időt.

//Progcont: https://progcont.hu/progcont/100317/?pid=201428

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Debit{
    private String loaner;
    private String debtor;
    private int debt;

    public Debit(String loaner, String debtor, int debt) {
        this.loaner = loaner;
        this.debtor = debtor;
        this.debt = debt;
    }

    /**
     * Megnöveli az eddigi adósságot a debt összegével.
     * @param debt A tartozás új tétele.
     */
    public void addDebt(int debt){
        this.debt = this.debt + debt;
    }

    /**
     * Egy statikus parancs, amely megkeres egy listtában egy adósságot. Ha nem találj, akkor null-al tér vissza.
     * @param loaner A keresett adósság hitelezőjének a neve.
     * @param debtor A keresett adósság adósának a neve.
     * @param debits A lista, amiben keresünk
     * @return A keresett adósság, vagy null.
     */
    public static Debit searchInList(String loaner, String debtor, List<Debit> debits){
        for (Debit debit : debits) {
            if (debit.loaner.equals(loaner) && debit.debtor.equals(debtor)) {
                return debit;
            }
        }
        return null;
    }

    // toString a kiíráshoz.
    @Override
    public String toString() {
        return debtor + " => " + loaner + ": " + debt;
    }

    //Getterek a rendezéshez.
    public String getLoaner() { return loaner.toLowerCase(); }
    public String getDebtor() { return debtor.toLowerCase(); }
}

public class TartozasokOsztaly {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Debit> debits = new ArrayList<>();
        while( (line=bf.readLine()) != null ){
            //Adatok feldarabolása és hozzáadása a listához.
            String[] data = line.split(";");
            // data[0] - a hitelező neve, data[1] - a tartozás, data[2-...] - az adós neve
            String loaner = data[0];
            int debt = Integer.parseInt(data[1]);
            //Az összes adósnak hitelez a hitelező
            for(int i = 2; i < data.length; i++){
                String debtor = data[i];
                // Ha már volt korábbi tartozás, akkor növelem, ha nem, akkor újat hozok létre.
                Debit result = Debit.searchInList(loaner, debtor, debits);
                if(result != null){
                    result.addDebt(debt);
                }else{
                    debits.add(new Debit(loaner, debtor, debt));
                }
            }
        }
        // Rendezés és kiírás
        debits.sort(Comparator.comparing(Debit::getDebtor).thenComparing(Debit::getLoaner));
        debits.forEach( item -> System.out.println(item.toString()) );
    }
}
