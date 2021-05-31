import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {
    private List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {

        this.tasks = tasks;

    }

    List<Thread> threads = new ArrayList<>();

    public void executeAll() {

        for (Runnable task : this.tasks) {
            Thread th = new Thread();
            this.threads.add(th);
        }

        for (Thread th : threads) {
            th.start();
        }


    }

}
