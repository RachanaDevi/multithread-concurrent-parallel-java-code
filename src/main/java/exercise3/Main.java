package main.java.exercise3;

import main.java.exercise3.threads.hacker.AscendingHackerThread;
import main.java.exercise3.threads.hacker.DescendingHackerThread;
import main.java.exercise3.threads.police.PoliceThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.java.exercise3.Constants.MAX_PASSWORD;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for(Thread thread: threads){
            thread.start();
        }

    }
    /*
    runnable -> thread
    thread is of 2 types:
    - hacker thread (and also has reference to vault)
    - police thread
    - ascending thread
    - descending thread
     */


}

