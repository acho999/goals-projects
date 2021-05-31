public class BlockingTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
