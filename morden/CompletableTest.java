import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CompletableTest {
    public static void main(String[] args) {
        int x = 1337;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> y = executorService.submit(() -> fo(x));
        Future<Integer> z = executorService.submit(() -> go(x));
        try {

            System.out.println(y.get() +"+"+ z.get());

            System.out.println(y.get() + z.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    public static Integer fo(int x) {
        return Integer.valueOf(x * 2);
    }

    public static Integer go(int x) {
        return Integer.valueOf(x + 1);
    }
}