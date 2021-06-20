package java8.lambdaExpression.lambdaVsAnonymousClass;

public class RunnableWithLambda {

    public static void main(String[] args) {

        //Lambda Expression
        Runnable runnable = () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        };

        Thread lambdaThread = new Thread(runnable);
        lambdaThread.start();
    }
}
