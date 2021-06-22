package concurrency.threadgroup;

public class ThreadGroupExample {

    public static void main(String[] args) {

        //Constructor 1:
        //ThreadGroup threadGroupReference = new ThreadGroup(String threadGroupName);
        //It will be executed by main thread and thread group of main thread is main
        //Any Thread Group Created by main thread will be child thread group of main thread group
        ThreadGroup userThreadGroup = new ThreadGroup("User-Thread-Group");
        System.out.println("User-Thread-Group's Parent : " + userThreadGroup.getParent().getName());

        //Constructor 2:
        //ThreadGroup threadGroupReference = new ThreadGroup(ThreadGroup parentThreadGroup, String threadGroupName);
        ThreadGroup subUserThreadGroup = new ThreadGroup(userThreadGroup, "Sub-User-Thread-Group");
        System.out.println("Sub-User-Thread-Group's Parent : " + subUserThreadGroup.getParent().getName());

        //Default Max Priority of Threads in Thread Group is 10
        System.out.println("Sub-User-Thread-Group's default MAX priority : " + subUserThreadGroup.getMaxPriority());
        System.out.println("User-Thread-Group's default MAX priority : " + userThreadGroup.getMaxPriority());

        //This thread are created by main thread hence priority of these are 5 which is equals to main thread priority
        Thread subUserThreadOne = new Thread(subUserThreadGroup, "sub-user-thread-one");
        Thread subUserThreadTwo = new Thread(subUserThreadGroup, "sub-user-thread-two");
        System.out.println("sub-user-thread-one's priority : " + subUserThreadOne.getPriority());
        System.out.println("sub-user-thread-two's priority : " + subUserThreadTwo.getPriority());

        //Changing priority of Sub User Thread Group
        System.out.println("Sub-User-Thread-Group Priority Changed !");
        subUserThreadGroup.setMaxPriority(3);
        System.out.println("Sub-User-Thread-Group's current MAX priority : " + subUserThreadGroup.getMaxPriority());

        //Priority will not change for already created thread, but for new thread it will change
        System.out.println("sub-user-thread-one's priority : " + subUserThreadOne.getPriority());
        System.out.println("sub-user-thread-two's priority : " + subUserThreadTwo.getPriority());
        Thread subUserThreadThree = new Thread(subUserThreadGroup, "sub-user-thread-three");
        System.out.println("sub-user-thread-three's priority : " + subUserThreadThree.getPriority());
    }
}
