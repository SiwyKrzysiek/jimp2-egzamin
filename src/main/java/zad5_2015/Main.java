package zad5_2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kontakt kontakt1 = new Kontakt("Paweł", "Ekler");
        kontakt1.dodajNumer(231412438);
        Kontakt kontakt2 = new Kontakt("Hania", "Beczka");

        List<Kontakt> kontakty = new ArrayList<>(Arrays.asList(kontakt1, kontakt2));
        kontakty.add(new Kontakt("Łukasz", "Dobry"));

        Collections.sort(kontakty);
        for (Kontakt k : kontakty)
            System.out.println(k);
    }
}
