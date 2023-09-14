package main.java.exercise2;

public class CreatedThreads {

    public static void main(String[] args) {
        Thread thread = new NewThread();

        thread.start();
    }

    private static class NewThread extends Thread {

        @Override
        public void run() {
            //code that executes on the new thread
            // we get a lot of access data and methods instead of using Thread.currentThread.getName()
            System.out.println("Hello from " + Thread.currentThread().getName());
            System.out.println("Hello from " + this.getName());
        }
    }
}
