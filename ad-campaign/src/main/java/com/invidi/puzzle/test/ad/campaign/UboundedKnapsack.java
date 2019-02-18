package com.invidi.puzzle.test.ad.campaign;

import java.util.Arrays;

public class UboundedKnapsack { 
    
    private int max(int i, int j) { 
            return (i > j) ? i : j; 
    } 
    
    private static void setAllArrayValueTo(int[] array, int value){
	    for (int i=0;i<array.length;i++) array[i] = value;
	}
    // Returns the maximum value with knapsack 
    // of W capacity 
    public int unboundedKnapsack(int W, int n,  
                                int[] val, int[] wt) { 
    			
        int dpw[] = new int[W + 1];
        int dpl[] = new int[W + 1];
        setAllArrayValueTo(dpl, -1);
        // Fill dp[] using above recursive formula 
        for(int i = 0; i <= W; i++){ 
            for(int j = 0; j < n; j++){ 
                if(wt[j] <= i){ 
                    int firstOption = dpw[i];
                    int secondOption = dpw[i - wt[j]] + val[j];
					dpw[i] = max(firstOption, secondOption); 
                  
					if(secondOption > firstOption) {
						dpl[i] = j;
					}
					
                } 
            } 
        }
        //Arrays.stream(dp).boxed().forEach(System.out::println)	;
   //     return dp[W];
        Arrays.stream(dpl).boxed().forEach(System.out::println);
        System.out.println("first method = "+dpw[W]);
    	
        System.out.println("==========");
    	int dp[][] = new int[n][W+1]; 
    	
    	for(int i = 0 ; i < n ; i++ ) {
    		for(int w = 0 ; w <= W ; w++) {
    			if(i == 0 || w == 0) {
    				dp[i][w] = 0;
    			} else if (wt[i] <= w) {
    				/*dp[i][w] = max(dp[i-1][w], dp[i-1][w- wt[i]] +  
                            val[i]);*/
    				dp[i][w] = max( (val[i]) + (dp[i-1][w- wt[i]]) , dp[i-1][w]);
    			} else {
    				dp[i][w] = dp[i-1][w];
    			}
    		}
    		//50071004
    	}
    	return dp[n-1][W];
    } 
  
} 