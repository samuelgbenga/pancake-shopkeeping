package org.example;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Pancake pancake = new Pancake();

        Random random = new Random();

        // Create and start ShopKeeper thread
        Thread shopKeeper = new Thread(new ShopKeeper(pancake));
        shopKeeper.start();


        int totalUserPancakes = 0;
        Thread user = null;
        // Create and start User threads
        for (int i = 1; i <= 3; i++) {
            int randomVal = random.nextInt(5) + 1;
             user = new Thread(new User(pancake, randomVal), "User " + i);
            totalUserPancakes += randomVal;
            user.start();
        }

        try {
            shopKeeper.join();// Wait for the shopkeeper to finish
        } catch (InterruptedException e) {
            throw new RuntimeException("An error occurred: " + e.getMessage(), e);
        }

        try {
            user.join();// Wait for the shopkeeper to finish
        } catch (InterruptedException e) {
            throw new RuntimeException("An error occurred: " + e.getMessage(), e);
        }

        Thread wastage = new Thread(new PancakeWastage(totalUserPancakes,pancake.getAmount()), "wastage");
        wastage.start();


    }


}
