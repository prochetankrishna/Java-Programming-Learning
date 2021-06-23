package concurrency.executorframework;

class ParentThread2 extends Thread {

    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>() {

        @Override
        protected String childValue(String parentValue) {
            return "CHILD";
        }
    };

    @Override
    public void run () {
        inheritableThreadLocal.set("PARENT");
        System.out.println("Parent Inheritable Thread Local Value : " + inheritableThreadLocal.get());
        ChildThread2 childThread2 = new ChildThread2();
        childThread2.start();
    }
}

class ChildThread2 extends Thread {

    @Override
    public void run () {
        System.out.println("Child Inheritable Thread Local Value : " + ParentThread.inheritableThreadLocal.get());
    }
}
public class ThreadLocalInheritanceExample2 {

    public static void main(String[] args) {
        ParentThread2 parentThread2 = new ParentThread2();
        parentThread2.start();
    }
}
