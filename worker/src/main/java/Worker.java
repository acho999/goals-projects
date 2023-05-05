import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Worker{

    public static class ExecutedTasks {

         public final List<Runnable> successful = new ArrayList<>();
         public final Set<Runnable> failed = new HashSet<>();
         public final Set<Runnable> timedOut = new HashSet<>();
     }

     public ExecutedTasks execute(Collection<Runnable> actions, long timeoutMillis) throws InterruptedException {

        final ExecutedTasks result = new ExecutedTasks();//it is final because it is initialized only once and will not be changed
        final ExecutorService executorService = Executors.newFixedThreadPool(actions.size());

         Map<Future<?>, Runnable> m = new LinkedHashMap<>();
         for (Runnable action : actions) {
             m.put(executorService.submit(action), action);
         }

         for (Map.Entry<Future<?>, Runnable> entry : m.entrySet()) {
             try {
                 entry.getKey().get(timeoutMillis, TimeUnit.MILLISECONDS);
                 result.successful.add(entry.getValue());
             } catch (ExecutionException e) {
                 result.failed.add(entry.getValue());
             } catch (TimeoutException e) {
                 result.timedOut.add(entry.getValue());
             }
         }
         executorService.shutdown();
         return result;
     }
 }