package pw.zad4_2015;

public class StubbornCounter extends Thread {
    private int count; //Bez przypisania wartości przyjmuje domyślnie 0

    //Nie ma konstruktora, więc kompilator dopisze konstruktor domyślny

    @Override
    public void run() {
        while (true) {
            count++;

            try {
                Thread.sleep(200); // W czasie spania wątek może być przerwany
            } catch (InterruptedException e) {
                count = 0;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
