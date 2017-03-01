import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.*;

public class Main {
	public static BlockingQueue<Long> s1 = new ArrayBlockingQueue<Long>(11);
    public static BlockingQueue<Long> s2 = new ArrayBlockingQueue<Long>(11);

    Thread c1;
	Thread p1;
	Thread p2;
	Thread p3;
	Thread p4;

    public static void main(String[] args) {
    	// Add numbers as seen in Hint 1, might not be pretty
    	s1.add(new Long(4));
    	s1.add(new Long(5));
    	s1.add(new Long(8));
    	s1.add(new Long(12));
    	s1.add(new Long(21));
    	s1.add(new Long(22));
    	s1.add(new Long(34));
    	s1.add(new Long(35));
    	s1.add(new Long(36));
    	s1.add(new Long(37));
    	s1.add(new Long(42));

    	//refactor(5);
    	
    	Main _main = new Main();
    	//_main.getAllFibs(s1);

    	long startTime = System.currentTimeMillis();

    	_main.refactor(1);
    	//_main.producerThreads();
    	_main.consumerThreads();


    	try {
	    	_main.c1.join();
    	} catch (InterruptedException ex) {
    		System.out.println("-- Error: " + ex);
    	}

		long endTime = System.currentTimeMillis();

		System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    private void refactor(int number) {
    	ExecutorService exec = Executors.newFixedThreadPool(number);
    	for (int i=0 ; i < number; i++ ) {
    		new Thread(new Producer()).start();

    	}
    }

    private void consumerThreads() {
    	c1 = new Thread(new Consumer());
    	c1.start();

    }

    private void producerThreads() {

    	p1 = new Thread(new Producer());
    	p2 = new Thread(new Producer());
    	p3 = new Thread(new Producer());
    	p4 = new Thread(new Producer());


    	p1.start();
    	p2.start();
    	p3.start();
    	p4.start();

    	// Debugging 
    	/*
    		try {
			_main.p1.join();
	    	_main.p2.join();
	    	_main.p3.join();
	    	_main.p4.join();
    	} catch (InterruptedException ex) {
    		System.out.println("-- Error: " + ex);
    	}
	*/
    	//printQueue(s2);
		
    }


    private void getAllFibs(BlockingQueue<Long> queue) {
    	boolean moreLeft = true;

   		Long t1 = queue.poll();
   		Long t2 = queue.poll();
   		Long t3 = queue.poll();
   		Long t4 = queue.poll();

   		Thread p1 = new Thread(new Producer());
    	Thread p2 = new Thread(new Producer());
    	Thread p3 = new Thread(new Producer());
    	Thread p4 = new Thread(new Producer());

    	p1.start();
    	p2.start();
    	p3.start();
    	p4.start();
 
    }

    private static void printQueue(BlockingQueue queue) {
    	Object temp = queue.poll();
    	while (temp != null) {
    		System.out.println(temp);
    		temp = queue.poll();
    	} 
    }
}