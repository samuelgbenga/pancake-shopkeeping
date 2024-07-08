package org.example;

public class User implements Runnable {
    private Pancake pancake;

    private final int amountPerUser;

    public User(Pancake pancake, int amountPerUser) {
        this.pancake = pancake;
        this.amountPerUser = amountPerUser;
    }

    @Override
    public void run() {
        synchronized (pancake) {
            while (!pancake.isReady()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " requested " + amountPerUser +" pancakes.");
                    pancake.wait(); // Wait until the pancake is ready
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " was interrupted.");
                    return;
                }
            }
        }
        if(pancake.isReady()){
        System.out.println(Thread.currentThread().getName() + " is eating the pancake.");
        }
    }

}

