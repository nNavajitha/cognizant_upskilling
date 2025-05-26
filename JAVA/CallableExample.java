import java.util.concurrent.*;
class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> task = () -> "Result from Callable";
        Future<String> future = executor.submit(task);
        System.out.println(future.get());
        executor.shutdown();
    }
}
