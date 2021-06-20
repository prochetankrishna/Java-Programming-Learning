class DisplayNumberCharacter {

    public synchronized void displayNumber() {

        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public synchronized void displayCharacter() {

        System.out.println();
        for (int i = 65; i <= 75; i++) {
            System.out.print((char) i + " ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

class NumberThread extends Thread {

    DisplayNumberCharacter displayNumberCharacter;

    NumberThread (DisplayNumberCharacter displayNumberCharacter) {
        this.displayNumberCharacter = displayNumberCharacter;
    }

    @Override
    public void run() {
        this.displayNumberCharacter.displayNumber();
    }
}

class CharacterThread extends Thread {

    DisplayNumberCharacter displayNumberCharacter;

    CharacterThread (DisplayNumberCharacter displayNumberCharacter) {
        this.displayNumberCharacter = displayNumberCharacter;
    }

    @Override
    public void run() {
        this.displayNumberCharacter.displayCharacter();
    }
}

public class SynchronizedExample {

    public static void main(String[] args) {

        DisplayNumberCharacter displayNumberCharacter = new DisplayNumberCharacter();

        NumberThread numberThread = new NumberThread(displayNumberCharacter);
        CharacterThread characterThread = new CharacterThread(displayNumberCharacter);

        numberThread.start();
        characterThread.start();
    }
}
