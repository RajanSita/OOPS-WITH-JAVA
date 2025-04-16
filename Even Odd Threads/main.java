public class main {
    public static void main(String[] args) {
        // Thread for printing even numbers
        Thread evenThread = new Thread(new EvenPrinter());
        // Thread for printing odd numbers
        Thread oddThread = new Thread(new OddPrinter());

        evenThread.start();
        oddThread.start();
    }
}

class EvenPrinter implements Runnable {
    public void run() {
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddPrinter implements Runnable {
    public void run() {
        for (int i = 1; i < 20; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(300);  
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
