package concurrency.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumCallable implements Callable<Integer> {

    int num;

    SumCallable (int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is responsible to find the sum of first " + this.num + " numbers");
        int sum = 0;
        for (int i = 1; i <= this.num; i++) {
            sum += i;
        }
        Thread.sleep(2000);
        return sum;
    }
}

public class CallableExample {

    public static void main(String[] args) throws Exception{

        SumCallable[] sumCallablesTask = {
                new SumCallable(10),
                new SumCallable(20),
                new SumCallable(30),
                new SumCallable(40),
                new SumCallable(50),
                new SumCallable(60)
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (SumCallable eachSumCallableTask : sumCallablesTask) {
            Future<Integer> future = executorService.submit(eachSumCallableTask);
            System.out.println(future.get());
        }
        executorService.shutdown();
    }

}
