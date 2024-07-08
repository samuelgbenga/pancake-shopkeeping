package org.example;

public class Pancake {
    private boolean ready = false;

    private int amount;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }
}