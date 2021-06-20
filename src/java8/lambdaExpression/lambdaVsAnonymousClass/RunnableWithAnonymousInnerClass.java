package java8.lambdaExpression.lambdaVsAnonymousClass;

public class RunnableWithAnonymousInnerClass {

    public static void main(String[] args) {

        //Anonymous Inner Class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + 1);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread anonymousThread = new Thread(runnable);
        anonymousThread.start();
    }
}
