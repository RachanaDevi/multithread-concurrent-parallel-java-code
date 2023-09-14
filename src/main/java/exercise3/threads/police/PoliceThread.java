package main.java.exercise3.threads.police;

public class PoliceThread extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Time: " + i);
        }
        System.out.println("Game over for you hackers");
        System.exit(0);
    }
}

