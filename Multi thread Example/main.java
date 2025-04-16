public class main {
    public static void main(String[] args) {
        
        FirstThread t1 = new FirstThread();
        t1.start();

        Runnable secondTask = new SecondRunnable();
        Thread t2 = new Thread(secondTask);
        t2.start();

        Thread t3 = new Thread(() -> {
            for (int i = 11; i <= 16; i++) {
                System.out.println("Thread 3 - Number: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
    }
}

class FirstThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1 - Number: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondRunnable implements Runnable {
    public void run() {
        for (int i = 6; i <= 10; i++) {
            System.out.println("Thread 2 - Number: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
