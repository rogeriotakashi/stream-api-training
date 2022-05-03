import java.util.function.Function;

public class main {
    public static void main(String[] args) {
        // Thread 0

        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };

        System.out.println("Hello World");

        // Classe explicita
//        Runnable runnable2 = new Outro();

        // Until Java 7 (Classes anonimas):
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello from Runnable");
//            }
//        };

        // Java 8 : Stream APIs, lambda expressions and FunctionalInterface
        // run()
        Runnable runnable = () -> System.out.println("Hello from Runnable");

//        Runnable runnable = () -> System.out.println("Hello from Runnable");


        Thread thread = new Thread(runnable);
        thread.start(); // Thread 1

        System.out.println("Seguindo o fluxo");
    }
}
