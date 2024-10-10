import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Problem5 {
    public static void main(String[] args) {


        Lock lock = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        final var count = new int[]{1, 1};
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while(count[0] < 101) {
                    lock.lock();
                    if (count[0] % 2 == 1 && count[0] < 101) {
                        System.out.print(count[0] + " ");
                        count[0] += 1;
                    }
                    lock.unlock();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while(count[0] < 101) {
                    lock.lock();
                    if (count[0] % 2 == 0 && count[0] < 101) {
                        System.out.print(count[0] + " ");
                        count[0] += 1;
                    }
                    lock.unlock();
                }
            }
        };


        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
