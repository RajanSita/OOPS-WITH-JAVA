// File: Main.java

public class main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SampleTask(), "MyThread");

        System.out.println("1. Thread Name (getName): " + t1.getName());
        
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("2. Thread Priority (getPriority): " + t1.getPriority());

        t1.start();

        System.out.println("3. Is Thread Alive? (isAlive): " + t1.isAlive());

        try {
            System.out.println("4. Main thread sleeping for 1 second (sleep)...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.join();
            System.out.println("5. After join(): Thread t1 has completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SampleTask implements Runnable {
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName());
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread running: count " + i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
