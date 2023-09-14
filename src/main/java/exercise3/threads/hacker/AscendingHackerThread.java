package main.java.exercise3.threads.hacker;

import main.java.exercise3.Vault;

import static main.java.exercise3.Constants.MAX_PASSWORD;

public class AscendingHackerThread extends HackerThread {

    public AscendingHackerThread(Vault vault) {
        super(vault);
        this.setName(this.getClass().getSimpleName());
    }

    @Override
    public void run() {
        for (int guess = 0; guess < MAX_PASSWORD; guess++) {
            if (vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
