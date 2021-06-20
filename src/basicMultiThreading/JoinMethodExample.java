package basicMultiThreading;

class CardDesignerThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts designing card");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " designing card completed");
    }
}

class CardPrinterThread extends Thread{

    private CardDesignerThread cardDesignerThread;

    public CardPrinterThread(CardDesignerThread cardDesignerThread) {
        this.cardDesignerThread = cardDesignerThread;
    }

    @Override
    public void run() {
        try {
            cardDesignerThread.join();
            System.out.println(Thread.currentThread().getName() + " starts printing card");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " printing card completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CardDistributorThread extends Thread{

    private CardPrinterThread cardPrinterThread;

    public CardDistributorThread(CardPrinterThread cardPrinterThread) {
        this.cardPrinterThread = cardPrinterThread;
    }

    @Override
    public void run() {
        try {
            cardPrinterThread.join();
            System.out.println(Thread.currentThread().getName() + " starts distributing card");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " distributing card completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class JoinMethodExample {

    public static void main(String[] args) {

        CardDesignerThread cardDesignerThread = new CardDesignerThread();
        CardPrinterThread cardPrinterThread = new CardPrinterThread(cardDesignerThread);
        CardDistributorThread cardDistributorThread = new CardDistributorThread(cardPrinterThread);

        cardDesignerThread.setName("Card-Designer-Thread");
        cardPrinterThread.setName("Card-Printer-Thread");
        cardDistributorThread.setName("Card-DistributorThread");

        cardDesignerThread.start();
        cardPrinterThread.start();
        cardDistributorThread.start();
    }
}
