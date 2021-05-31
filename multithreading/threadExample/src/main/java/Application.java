

public class Application {

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            System.out.println("Hello");
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello" + ' ' + Thread.currentThread().getName() + ' ' + "from first thread");
                System.out.println("Hello" + ' ' + Thread.currentThread().getPriority() + ' ' + "from first thread");
                throw new RuntimeException("Intentional exception");

            }

            ;
        });

        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {//this way we catch thread ex
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Hello" + ' ' + t.getName() + ' ' + e.getMessage());

            }
        });

        thread1.setName("My First Thread");//this way we set thread name
        thread1.setPriority(Thread.MAX_PRIORITY);//here we set priority of the thread can be from 1-10

        System.out.println("Hello" + ' ' + Thread.currentThread().getName() + ' ' + "before start");
        //when we want to debug threads we put breakpoints and run in debug mode
        //then we choose

        //it is pass thread to the operating system
        thread1.start();

        System.out.println("Hello" + ' ' + Thread.currentThread().getName() + ' ' + "after start");

        //Thread.sleep(1000);//method will sleep for one second


    }

}
