import java.io.Serializable;
import java.util.List;

import static java.lang.Thread.sleep;

public class Problem4 {
    public static void main(String[] args) {
        List<? extends Serializable> characterList = List.of("A", 'B', 'C', 'D', 'E');
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println(i + 1);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i  = 0; i < 5; i++){
                char c = (char) ('A' + i);
                System.out.println(c);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
