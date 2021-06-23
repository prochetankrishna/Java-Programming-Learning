package concurrency.executorframework;

public class ThreadLocalExample {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        System.out.println(threadLocal.get()); //Initial Value - null

        threadLocal.set("Chetan Krishna");
        System.out.println(threadLocal.get());

        threadLocal.remove();
        System.out.println(threadLocal.get());

        ThreadLocal<String> threadLocalWithUserDefinedInitialValue = new ThreadLocal<>() {
            public String initialValue () {
                return "Chanchal Krishna";
            }
        };
        System.out.println(threadLocalWithUserDefinedInitialValue.get());
    }
}
