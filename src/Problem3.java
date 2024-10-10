public class Problem3 {
    public static void main(String[] args) {
        var startTime = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            while(true){
                var currentTime = System.currentTimeMillis();
                var timeGone = currentTime - startTime;
                System.out.println("milliSeconds gone: " + timeGone);
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
