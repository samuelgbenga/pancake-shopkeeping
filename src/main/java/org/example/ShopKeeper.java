package org.example;


import java.util.Random;

public class ShopKeeper implements Runnable {
    private Pancake pancake;
    private boolean pancakeReady = false;

    Random random;

    public ShopKeeper(Pancake pancake) {
        this.pancake = pancake;
        random = new Random();
    }



    @Override
    public void run() {
        long endTime = System.currentTimeMillis() + 3000; // 30 seconds from now
        while (System.currentTimeMillis() < endTime) {
            System.out.println("ShopKeeper is making a pancake...");
            try {
                Thread.sleep(1000); // Simulate making pancake
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("ShopKeeper thread was interrupted.");
                return;
            }
        }
        synchronized (pancake) {
            pancake.setReady(true);
            pancake.setAmount(random.nextInt(12) + 1);
            pancake.notifyAll(); // Notify all waiting users
        }
        System.out.println("ShopKeeper has finished making the pancake.");
    }
}