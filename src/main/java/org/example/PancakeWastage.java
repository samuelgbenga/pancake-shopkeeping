package org.example;

public class PancakeWastage implements Runnable{

    private final int totalRequested;

    private final int totalMade;


    public PancakeWastage(int totalRequested, int totalMade) {
        this.totalRequested = totalRequested;
        this.totalMade = totalMade;
    }


    private void doWastage(){
        System.out.println("This are(is) the total amount ot pancakes wasted: "+ (totalMade-totalRequested));
    }

    private void doNotSatisfied(){
        System.out.println("This are(is) the total number of unsatisfied order: "+(totalRequested - totalMade));
    }


    @Override
    public void run() {

        if(totalRequested > totalMade){
            doNotSatisfied();
        }else if(totalRequested == totalMade) {
            System.out.println("There was no wastage all are satisfied");;
        }else {
            doWastage();
        }
    }
}
