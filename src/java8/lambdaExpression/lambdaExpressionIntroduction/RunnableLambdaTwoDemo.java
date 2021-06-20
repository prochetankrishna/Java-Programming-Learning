package java8.lambdaExpression.lambdaExpressionIntroduction;

/*
    This is also Functional Interface

    interface Runnable {
        public void run();
    }

 */
public class RunnableLambdaTwoDemo {

    public static void main(String[] args) {

        //Thread someThread = new Thread (RUNNABLE_OBJECT);

        Thread naturalNumberPrinter = new Thread (() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        naturalNumberPrinter.start();
    }
}
