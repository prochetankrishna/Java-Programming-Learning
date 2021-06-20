package multithreading.interThreadCommunication;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class AssemblyStation {

    Queue<String> assemblyLine;
    int capacity = 2;
    AssemblyStation () {
        assemblyLine = new LinkedList<>();
    }

    public boolean isAssemblyLineFull() {
        return assemblyLine.size() == 2;
    }

    public boolean isAssemblyLineEmpty() {
        return assemblyLine.size() == 0;
    }
}

class Producer extends Thread {

    static String[] cars = new String[]{"Tesla Model X", "Tesla Model Y", "Tesla Model 3", "Tesla Model S"};
    Random random = new Random();
    AssemblyStation assemblyStation;

    Producer (AssemblyStation assemblyStation) {
        this.assemblyStation = assemblyStation;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (assemblyStation) {
                if (assemblyStation.isAssemblyLineFull()) {
                    try {
                        assemblyStation.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                } else {
                    if (!assemblyStation.isAssemblyLineFull()) {
                        String producedCar = cars[random.nextInt(cars.length)];
                        this.assemblyStation.assemblyLine.offer(producedCar);
                        System.out.println(assemblyStation.assemblyLine);
                        System.out.println("Produced [" + producedCar + "]");
                        this.assemblyStation.capacity++;
                        assemblyStation.notify();
                    }
                }
            }
        }
    }
}

class Consumer extends Thread {

    AssemblyStation assemblyStation;

    Consumer (AssemblyStation assemblyStation) {
        this.assemblyStation = assemblyStation;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (assemblyStation) {
                if (assemblyStation.isAssemblyLineEmpty()) {
                    try {
                        assemblyStation.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                } else {
                    if (!assemblyStation.isAssemblyLineEmpty()){
                        String consumedCar = assemblyStation.assemblyLine.poll();
                        this.assemblyStation.capacity--;
                        System.out.println("Consumed Car [" + consumedCar + "]");
                        assemblyStation.notify();
                    }
                }
            }
        }
    }
}
public class ProducerConsumerExample {

    public static void main(String[] args) {

        AssemblyStation assemblyStation = new AssemblyStation();
        Producer producerThread = new Producer(assemblyStation);
        Consumer consumerThread = new Consumer(assemblyStation);

        producerThread.start();
        consumerThread.start();
    }
}
