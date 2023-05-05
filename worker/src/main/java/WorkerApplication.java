import java.util.ArrayList;
import java.util.List;

public class WorkerApplication {
    public static void main(String[] args) {

        Worker worker = new Worker();
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tasks.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("completed task - " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Worker.ExecutedTasks result = worker.execute(tasks,1000);
            System.out.println(result.successful);
            System.out.println(result.failed);
            System.out.println(result.timedOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
