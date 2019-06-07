package zad5_2015;

import java.util.*;

public class Kontakt implements Comparable<Kontakt> {
    private String imie;
    private String nazwisko;
    private List<Integer> numery;

    public Kontakt(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        numery = new ArrayList<>();
    }

    public void dodajNumer(int nowyNumer) {
        numery.add(nowyNumer);
    }

    public void usunNumer(int numer) {
        numery.remove(numer);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(imie).append(" ").append(nazwisko);
        result.append(" numery: ");

        //result.append(String.join(", ", numery.stream().map(String::valueOf).toArray(String[]::new))); //Podejście na strumieniach

        //Standardowe rozwiązanie
        if (numery.size() >0 )
            result.append(numery.get(0));
        for (int i = 1; i < numery.size(); i++) {
            result.append(", ").append(numery.get(i));
        }

        return result.toString();
    }

    @Override
    public int hashCode() {
        int sumaNumerow = 0;
        //sumaNumerow = numery.stream().mapToInt(n -> n).sum(); //Wersja ze strumieniem;

        for (int numer : numery)
            sumaNumerow += numer;

        return 31 * imie.hashCode() + 37 * nazwisko.hashCode() + 41 * sumaNumerow;
    }

    @Override
    public boolean equals(Object inny) {
        if (inny == null) return false;
        if (inny == this) return true;

        if (! (inny instanceof Kontakt)) return false;
        Kontakt kontakt = (Kontakt) inny;

        return kontakt.imie.equals(imie) && kontakt.nazwisko.equals(nazwisko) && kontakt.numery.equals(numery);
    }

    public int compareTo(Kontakt inny) {
        if (nazwisko.compareTo(inny.nazwisko) != 0)
            return nazwisko.compareTo(inny.nazwisko);
        else
            return imie.compareTo(inny.imie);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Integer> getNumery() {
        return numery;
    }
}
