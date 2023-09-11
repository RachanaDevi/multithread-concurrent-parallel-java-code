package main.java.exercise1;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("We are now in thread: " + Thread.currentThread().getName());
            System.out.println("Priority is: " + Thread.currentThread().getPriority());
        };

        Thread thread = new Thread(runnable);
        thread.setName("New worker thread"); // adding names of thread with meaningful names
        thread.setPriority(Thread.MAX_PRIORITY); // add priority
        System.out.println("Before starting thread, we are in thread: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("After starting thread, we are in thread: " + Thread.currentThread().getName());

        thread.setUncaughtExceptionHandler((threadCaught, exception) -> {
            System.out.println("A critical error happened in thread " + thread.getName() + " having exception " + exception);
        });
    }
}
