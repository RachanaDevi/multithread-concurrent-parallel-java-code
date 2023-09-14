package main.java.exercise4;

import java.math.BigInteger;
import java.time.Duration;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        LongComputationTask task = new LongComputationTask(new BigInteger("20"), new BigInteger("100000"));
        Thread thread = new Thread(task);
        thread.setDaemon(true); // we set it to true, so even if our thread is not finished, the main thread finishes so
        // the program stops
        // if you set it as false, it will still continue even though main thread has ended


        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        System.out.println("Main thread ended");
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
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Prematurely interrupted computation");
//                    return BigInteger.ONE;
//                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}


