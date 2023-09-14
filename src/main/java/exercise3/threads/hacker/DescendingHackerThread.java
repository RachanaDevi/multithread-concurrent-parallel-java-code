package main.java.exercise3.threads.hacker;

import main.java.exercise3.Vault;

import static main.java.exercise3.Constants.MAX_PASSWORD;

public class DescendingHackerThread extends HackerThread {


    public DescendingHackerThread(Vault vault) {
        super(vault);
        this.setName(this.getClass().getSimpleName());
    }

    @Override
    public void run() {
        for (int guess = MAX_PASSWORD; guess >= 0; guess--) {
            if (this.vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
