public class MultithreadingExample {
    public static void main(String[] args) throws InterruptedException {
        Example example = new Example();

        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(()->{
            example.findPrimeNumberParallel(10,example.primeNumbers,1500);
        });
        Thread thread2 = new Thread(()->{
            example.findPrimeNumberParallel(1501,example.primeNumbers,3000);
        });
        Thread thread3 = new Thread(()->{
            example.findPrimeNumberParallel(3001,example.primeNumbers,4500);
        });
        Thread thread4 = new Thread(()->{
            example.findPrimeNumberParallel(4501,example.primeNumbers,6000);
        });

        //BiPredicate<Integer,Integer> a = (a)

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("time - " + timeElapsed);
        System.out.println(example.primeNumbers.size());
        System.out.println(example.primeNumbers);
    }
}
