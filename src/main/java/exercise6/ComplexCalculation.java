package main.java.exercise6;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class ComplexCalculation {
    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;
        PowerCalculatingThread firstThread = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread secondThread = new PowerCalculatingThread(base2, power2);
        
        List<Thread> allThreads = new ArrayList<>();
        allThreads.add(firstThread);
        allThreads.add(secondThread);
        
        for(Thread thread: allThreads){
            thread.start();
        }
        
        for(Thread thread: allThreads){
            thread.join();
        }

        result = firstThread.getResult().add(secondThread.getResult()); 
        
        
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
          for(int exponent=1; exponent<= power.doubleValue(); exponent++){
              result=result.multiply(base);
          }
        }
    
        public BigInteger getResult() { return result; }
    }

    public static void main(String[] args) throws InterruptedException {
        BigInteger answer = ComplexCalculation.calculateResult(
                BigInteger.valueOf(20L), BigInteger.valueOf(2L),
                BigInteger.valueOf(10L), BigInteger.valueOf(2L)
        );
        System.out.println(answer);
    }
}