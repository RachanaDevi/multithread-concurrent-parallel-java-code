package main.java.exercise1;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("We are now in thread: "+ Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        System.out.println("Before starting thread, we are in thread: "+Thread.currentThread().getName());
        thread.start();;
        System.out.println("After starting thread, we are in thread: "+Thread.currentThread().getName());
    }
}
