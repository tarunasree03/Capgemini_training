package advance_java.day3.threads;

class Example {

    public synchronized void waitMethod() throws InterruptedException {
        System.out.println("Thread 1: Waiting...");
        wait();   // waits
        System.out.println("Thread 1: Resumed!");
    }

    public synchronized void notifyMethod() throws InterruptedException {
        Thread.sleep(2000);  // sleep 2 seconds
        System.out.println("Thread 2: Notifying...");
        notify();  // wakes waiting thread
    }
}

public class Main1 {
    public static void main(String[] args) {

        Example obj = new Example();

        Thread t1 = new Thread(() -> {
            try {
                obj.waitMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                obj.notifyMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}


