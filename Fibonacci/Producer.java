import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {


	@Override
	public void run() {
		Long number = Main.s1.poll();
		Long fibnumber;
		while (number != null) {
			fibnumber = fib(number);
			//System.out.println("Thread: " + Thread.currentThread().getId() + " - The fib number of " + number + " is " + fibnumber);
			try {
				Main.s2.put(fibnumber);
			} catch (InterruptedException ex) {
				System.out.println("-- Error: " + ex);
			}
			number = Main.s1.poll();
		}

	}

	private Long fib(Long n) {
		if ((n == 0) || (n==1)) {
			return n;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
}