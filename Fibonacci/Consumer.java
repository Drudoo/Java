import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {


	@Override
	public void run() {
		Long sum = 0L;
		Long number = 0L;
		
		try {
			number = Main.s2.take();
		} catch (InterruptedException ex) {
			System.out.println("-- Error: " + ex);
		}

		boolean run = true;
		int length = 0;

		while(length < 10 && number != 0) {

			sum = sum + number;
			System.out.println("Fib: " + number + " - Sum: " + sum);
			length++;
			
			try {
				number = Main.s2.take();
			} catch (InterruptedException ex) {
				System.out.println("-- Error: " + ex);
			}
		}
		System.out.println("Total sum: " + sum);

	}
}