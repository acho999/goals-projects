import java.util.*;

public class Application {
    public static void main(String[] args) {

        //Thread thread = new NewThread();
        // thread.start();

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(999));

        List<Thread> threads = new ArrayList<Thread>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for (Thread th : threads) {

            th.start();

        }


    }

    private static class NewThread extends Thread {//this is how we create new class thread

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hi" + ' ' + this.getName());
        }
    }
}

