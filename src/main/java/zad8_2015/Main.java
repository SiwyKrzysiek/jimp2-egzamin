package zad8_2015;

public class Main {
    public static void main(String[] args) {
        ConcurrentStack stack = new ConcurrentStack();

        stack.push("Panda3");
        stack.push(5);

        stack.pop();
        stack.pop();

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Wystartowałem");
                try {
                    sleep(300);
                } catch (InterruptedException e) {

                }

                System.out.println("Wstawiam wiadomosc");
                stack.push("Ukryta wiadomosc");
            }
        };

        thread.start();

        System.out.println("Chcę przeczytać wiadomość");
        System.out.println(stack.pop());
    }
}
