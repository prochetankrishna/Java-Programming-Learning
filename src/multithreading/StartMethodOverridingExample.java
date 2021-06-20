package multithreading;

class Game extends Thread {

    @Override
    public void start() {
        super.start();
        System.out.println("Game::start() Method");
    }

    @Override
    public void run() {
        System.out.println("Game::run() Method [" + Thread.currentThread().getThreadGroup() + "]");
    }
}

public class StartMethodOverridingExample {

    public static void main(String[] args) {

        Game gameThread = new Game();
        gameThread.start();
        System.out.println("Main::main() Method");
    }
}
