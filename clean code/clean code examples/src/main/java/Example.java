import java.util.concurrent.ConcurrentSkipListSet;

public class Example {

    public volatile ConcurrentSkipListSet<Integer> primeNumbers = new ConcurrentSkipListSet<>();
    private final Object obj = new Object();

    public void findPrimeNumberParallel(int start,ConcurrentSkipListSet<Integer> primeNumbers, int bound){
            for (int i = start; i <= bound; i++) {
                if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0 && i % 9 != 0) {
                    System.out.println(Thread.currentThread().getName() + " - added the number");
                    synchronized (obj){
                        primeNumbers.add(i);
                    }

                }
            }
    }

}
