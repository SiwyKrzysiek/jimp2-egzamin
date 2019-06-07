package pw.zad4_2015;

public class Main {
    public static void main(String[] args) {
        StubbornCounter counter = new StubbornCounter();
        counter.setDaemon(true); //Gdy program główny się skończy wątek zosanie automatycznie zabity
        counter.start();

        for (int i = 0; true; i++) {
            System.out.println(counter.getCount());

            if (i % 13 == 0)
                counter.interrupt();

            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
