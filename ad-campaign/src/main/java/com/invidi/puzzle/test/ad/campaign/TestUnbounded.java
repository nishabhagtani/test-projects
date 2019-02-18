package com.invidi.puzzle.test.ad.campaign;

import java.util.Scanner;

public class TestUnbounded {

	private static int   maxWeight = 0; //maximum weight of knapsack
	private static int[] w;             //weight of each item
	private static int[] v;             //value of each item
	private static int[] a;             //maximum value each knapsack
	private static int[] l;             //last item added each knapsack
	
	public static void main(String[] args)
	{
	    if (!getData()) return;             //getting data from user
	    fillUnboundedKnapsack();            //run the algorithm
	    int[] optimal = trackCombination(); //seek for items combination
	 
	    /* Just an Output Step */
	    System.out.println("Maximum Value : " + a[a.length-1]);
	    System.out.print("Combination : ");
	    for (int i=0;i<optimal.length;i++){
	        System.out.print(optimal[i] + " ");
	    }
	    System.out.println();
	}
	
	private static boolean getData(){
	    System.out.print("Input Maximum Knapsack Weight : ");
	        maxWeight = new Scanner(System.in).nextInt();
	 
	    System.out.print("Input the weight of each item (separate by space) : ");
	        String[] temp = new Scanner(System.in).nextLine().split(" ");
	        w = new int[temp.length];
	        for (int i=0;i<temp.length;i++) w[i] = Integer.valueOf(temp[i]);
	 
	    System.out.print("Input the value of each item (separate by space) : ");
	        temp = new Scanner(System.in).nextLine().split(" ");
	        v = new int[temp.length];
	        for (int i=0;i<temp.length;i++) v[i] = Integer.valueOf(temp[i]);
	 
	    if (w.length != v.length){
	        System.err.println("Number of weight and value data not match!");
	        return false;
	    }
	    return true;
	}
	
	private static void fillUnboundedKnapsack()
	{
	    int   n = w.length;         //number of items
	 
	    /**
	     * Initializing table
	     * table a with default value =  0
	     * table l with default value = -1
	     */
	    a = new int[maxWeight+1];
	    l = new int[maxWeight+1];
	 
	    setAllArrayValueTo(a,  0);
	    setAllArrayValueTo(l, -1);
	 
	    /**
	     * Unbounded Knapsack Step
	     */
	    for (int i=1;i<a.length;i++)
	    {
	        for (int j=0;j<n;j++)
	        {
	            if (w[j] <= i &&
	                    (v[j] + a[i - w[j]]) > a[i])
	            {
	                a[i] = v[j] + a[i - w[j]];
	                l[i] = j;
	            }
	        }
	    }
	}
	
	private static void setAllArrayValueTo(int[] array, int value){
	    for (int i=0;i<array.length;i++) array[i] = value;
	}
	
	private static int[] trackCombination()
	{
	    int[] combination = new int[w.length];
	 
	    int postTracker = l.length-1;
	    int itemTracker = l[postTracker];
	 
	    /**
	     * Tracking back the combination
	     */
	    while (itemTracker != -1 && postTracker > 0)
	    {
	        combination[itemTracker]++;
	        postTracker = postTracker - w[itemTracker];
	        itemTracker = l[postTracker];
	    }
	 
	    return combination;
	}
	
}