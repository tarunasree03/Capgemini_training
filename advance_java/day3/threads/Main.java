package advance_java.day3.threads;

class MultiThreading extends Thread {
	
	int threadNumber;
	public MultiThreading (int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	public void run() {
		for(int i =1; i<=5; i++) {
			System.out.println(i + "Thread Number: " + threadNumber);
			if (threadNumber == 3) {
				throw new RuntimeException();
			}
			try {
				Thread.sleep(1000);
				}
			catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

public class Main{
	public static void main(String[] args) {
//		MultiThreading th1 = new MultiThreading();
//		MultiThreading th2 = new MultiThreading();
//		
//		th1.start();
//		th2.start();
//		
//		th1.run();
//		th2.run();
		
		for(int i = 0; i < 5; i++) {
			MultiThreading th = new MultiThreading(i);
			th.start();
		}
	
	}
}
