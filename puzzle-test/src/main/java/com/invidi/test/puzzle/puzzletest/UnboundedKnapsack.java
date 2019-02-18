package com.invidi.test.puzzle.puzzletest;

import java.text.NumberFormat;

public class UnboundedKnapsack {
	 
    protected Item []  items = {
                               /*new Item("Acme", 200,  2000000),
                               new Item("Lorem"  , 400,  3500000),
                               new Item("Ipsum"   , 210,  2300000),
                               new Item("Dolor"   , 730,  8000000),
                               new Item("SIT"   , 1000,  10000000),
                               new Item("Amet"   , 160,  1500000),
                               new Item("Mauris"   , 100,  1000000)*/
                               new Item("Acme" , 0,  1),
                              	new Item("Lorem" , 2,  2),
                              	new Item("Ipsum" , 2,  3),
                              	new Item("Dolor" , 71000,  70000),
                              	new Item("Mauris",50000000,49000000)
                               };
    protected final int    n = items.length; // the number of items
    protected Item      sack = new Item("sack" , 0, 50000000);
    protected Item      best = new Item("best" , 0,  0);
    protected int  []  maxIt = new int [n];  // maximum number of items
    protected int  []    iIt = new int [n];  // current indexes of items
    protected int  [] bestAm = new int [n];  // best amounts
 
    public UnboundedKnapsack() {
        // initializing:
        for (int i = 0; i < n; i++) {
            /*maxIt [i] = Math.min(
                           (int)(sack.getWeight() / items[i].getWeight()),
                           (int)(sack.getVolume() / items[i].getVolume())
                        );*/
            
            maxIt [i] = (int)(sack.getWeight() / items[i].getWeight());
        } // for (i)
 
        // calc the solution:
        calcWithRecursion(0);
 
        // Print out the solution:
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("Maximum value achievable is: " + best.getValue());
        System.out.print("This is achieved by carrying (one solution): ");
        for (int i = 0; i < n; i++) {
            System.out.print(bestAm[i] + " " + items[i].getName() + ", ");
        }
        System.out.println();
        System.out.println("The weight to carry is: " + nf.format(best.getWeight()) /*+
                           "   and the volume used is: " + nf.format(best.getVolume())*/
                          );
 
    }
 
    // calculation the solution with recursion method
    // item : the number of item in the "items" array
    public void calcWithRecursion(int item) {
        for (int i = 0; i <= maxIt[item]; i++) {
            iIt[item] = i;
            if (item < n-1) {
                calcWithRecursion(item+1);
            } else {
                int currVal = 0;   // current value
                int currWei = 0; // current weight
                //double currVol = 0.0; // current Volume
                for (int j = 0; j < n; j++) {
                    currVal += iIt[j] * items[j].getValue();
                    currWei += iIt[j] * items[j].getWeight();
                    //currVol += iIt[j] * items[j].getVolume();
                }
 
                if (currVal > best.getValue()
                    &&
                    currWei <= sack.getWeight()
                    /*&&
                    currVol <= sack.getVolume()*/
                )
                {
                    best.setValue (currVal);
                    best.setWeight(currWei);
                    //best.setVolume(currVol);
                    for (int j = 0; j < n; j++) bestAm[j] = iIt[j];
                } // if (...)
            } // else
        } // for (i)
    } // calcWithRecursion()
}