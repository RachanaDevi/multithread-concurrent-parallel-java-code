package main.java.exercise4;

import java.math.BigInteger;
import java.time.Duration;

public class ThreadInterruption {

    public static void main(String[] args) {
        LongComputationTask task = new LongComputationTask(new BigInteger("20000"), new BigInteger("10"));
        Thread thread = new Thread(task);


        long startTime = System.currentTimeMillis();
        System.out.println("STARTING TIME: " + startTime);
        long endTime = startTime + Duration.ofMillis(10000).toMillis();
        thread.start();
        while (true) {
            if (System.currentTimeMillis() > endTime) {
                thread.interrupt();
                System.out.println("Thread got interrupted and now exiting ");
                System.exit(0);
            }
        }
    }

    private static class LongComputationTask implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ONE;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}


