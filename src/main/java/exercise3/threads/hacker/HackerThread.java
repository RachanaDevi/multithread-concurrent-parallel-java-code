package main.java.exercise3.threads.hacker;

import main.java.exercise3.Vault;

public class HackerThread extends Thread {

    protected Vault vault;

    public HackerThread(Vault vault) {
        this.vault = vault;
        this.setName("Hacker thread");
        this.setPriority(Thread.MAX_PRIORITY);
    }


    @Override
    public void start() {
        System.out.println("Starting thread: " + this.getName());
        super.start();
    }
}
