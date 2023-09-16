package main.java.exercise5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);
        // we want to calculate the !0, !3435 all the factorials

        List<FactorialThread> factorialThreads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            factorialThreads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : factorialThreads) {
            thread.start();
        }

        for(Thread thread: factorialThreads){
            thread.join();
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = factorialThreads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            }
            else{
                System.out.println("The calculation for "+ inputNumbers.get(i));
            }
        }
    }
}
