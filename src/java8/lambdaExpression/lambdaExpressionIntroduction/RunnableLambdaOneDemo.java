package java8.lambdaExpression.lambdaExpressionIntroduction;

/*
    This is also Functional Interface

    interface Runnable {
        public void run();
    }

 */
public class RunnableLambdaOneDemo {

    public static void main(String[] args) {

        Runnable runnable = () -> {

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread naturalNumberPrinter = new Thread (runnable);
        naturalNumberPrinter.start();
    }
}
