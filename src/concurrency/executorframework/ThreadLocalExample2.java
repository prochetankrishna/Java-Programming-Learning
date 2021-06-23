package concurrency.executorframework;

class CustomerThread extends Thread {

    static Integer customerId = 0;

    private static ThreadLocal threadLocal = new ThreadLocal() {
        protected Integer initialValue () {
            return ++customerId;
        }
    };

    CustomerThread (String threadName) {
        super(threadName);
    }

    @Override
    public void run () {
        System.out.println(Thread.currentThread().getName() + " executing with Customer ID : " + threadLocal.get());
    }
}

public class ThreadLocalExample2 {

    public static void main(String[] args) {
        CustomerThread customerThreadOne = new CustomerThread("customer-thread-one");
        CustomerThread customerThreadTwo = new CustomerThread("customer-thread-two");
        CustomerThread customerThreadThree = new CustomerThread("customer-thread-three");
        CustomerThread customerThreadFour = new CustomerThread("customer-thread-four");

        customerThreadOne.start();
        customerThreadTwo.start();
        customerThreadThree.start();
        customerThreadFour.start();
    }
}
