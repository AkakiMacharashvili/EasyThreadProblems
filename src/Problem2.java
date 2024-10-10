public class Problem2 {
    public static void main(String[] args) {


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.print("This is my priority: Thread1");
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("This is my priority: Thread2");
                }
            }
        };

        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("This is my priority: Thread3");
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.setPriority(10);
        thread2.setPriority(5);
        thread3.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
