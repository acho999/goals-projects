public class PoliceThread extends Thread {

    @Override
    public void run() {
        //super.run();
        for (int i = 10; i >= 0; i--) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);


        }
        System.out.println("Game over hackers!!!");
        System.exit(0);
    }
}
