class Printer {
    synchronized void printMessage(String message) {
        System.out.print("[ " + message);
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(" ]");
    }
}

class MessageThread extends Thread {
    private Printer printer;
    private String message;

    public MessageThread(Printer p, String msg) {
        this.printer = p;
        this.message = msg;
    }

    public void run() {
        printer.printMessage(message);
    }
}

public class main {
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer(); 

        MessageThread t1 = new MessageThread(sharedPrinter, "Hello");
        MessageThread t2 = new MessageThread(sharedPrinter, "Synchronized");
        MessageThread t3 = new MessageThread(sharedPrinter, "World");

        t1.start();
        t2.start();
        t3.start();
    }
}
