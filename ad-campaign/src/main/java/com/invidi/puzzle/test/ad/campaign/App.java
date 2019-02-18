package com.invidi.puzzle.test.ad.campaign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

/**
 * Hello world!
 *
 */
public class App {

	private String getFile(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();
		String result = "";
		try {
			result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println( "Hello World!" );
		 * 
		 * // we take the same instance of the problem displayed in the image Item[]
		 * items = {new Item("Acme",200,2000000), new Item("Lorem",400,3500000), new
		 * Item("Ipsum",210,2300000), new Item("Dolor",730,8000000), new
		 * Item("SIT",1000,10000000), new Item("Amet",160,1500000), new
		 * Item("Mauris",100,1000000)};
		 * 
		 * AdCampaign knapsack = new AdCampaign(items, 32356000); knapsack.display();
		 * Solution solution = knapsack.solve(); solution.display();
		 */

		System.out.println("enter file name:");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		// System.out.println("fileName - "+fileName);

		App obj = new App();
		String file = obj.getFile(fileName);

		scanner = new Scanner(file);
		final Integer monthlyInventory = scanner.nextInt();
		//String[] customerNames = Arrayutil;
		List<String> customerNames = new ArrayList<String>();
		List<Integer> impressionsPerCampaign = new ArrayList<Integer>();//wt
		List<Integer> pricePerCampaign = new ArrayList<Integer>();//value
		int count = 0;
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(line.trim().isEmpty()) {
				continue;
			}
			String[] fields = line.split(",");
			customerNames.add(fields[0]);
			impressionsPerCampaign.add(Integer.parseInt(fields[1]));
			pricePerCampaign.add(Integer.parseInt(fields[2]));
		}
		
		String[] custArr = new String[customerNames.size()];
		//System.out.println(customerNames + "  = customername = "+customerNames.toArray(custArr));
		
		int imp11[] = new int[impressionsPerCampaign.size()];
		Integer[] myArr = impressionsPerCampaign.stream().toArray(Integer[]::new);
		System.out.println("myArr = "+myArr);
		
		UboundedKnapsack uKnapsack = new UboundedKnapsack();

		/*
		 * int W = 50000000; //int val[] = {200, 400, 210, 730, 1000, 160, 100}; //int
		 * wt[] = {2000000, 3500000, 2300000, 8000000, 10000000, 1500000, 1000000 }; int
		 * val[] = { 0, 2, 2, 71000, 50000000}; //Mauris,49000000,50000000 int wt[] = {
		 * 1, 2, 3, 70000, 49000000}; //Acme,1000000,5000 int n = val.length;
		 */
		int W = 15;
		// int val[] = {200, 400, 210, 730, 1000, 160, 100};
		// int wt[] = {2000000, 3500000, 2300000, 8000000, 10000000, 1500000, 1000000 };
		int val[] = { 20, 20, 5 }; // Mauris,49000000,50000000
		int wt[] = { 6, 10, 4 }; // Acme,1000000,5000
		int n = val.length;

		// System.out.println(n);
		System.out.println(uKnapsack.unboundedKnapsack(W, n, val, wt));

		/// UnboundedKnapsack1 u = new UnboundedKnapsack1();
		// u.solve(W, n-1, val, wt);
		/*
		 * List<Customer> customers = Arrays.asList(new Customer("Acme", 2000000L,
		 * 200d), new Customer("Lorem", 3500000L, 400d), new Customer("Ipsum", 2300000L,
		 * 210d), new Customer("Dolor", 8000000L, 730d), new Customer("SIT", 10000000L,
		 * 1000d), new Customer("Amet", 1500000L, 160d), new Customer("Mauris",
		 * 1000000L, 100d));
		 */
		/*
		 * List<Customer> customers = Arrays.asList(new Customer("Acme", 1L, 0d), new
		 * Customer("Lorem", 2L, 2d), new Customer("Ipsum", 3L, 2d), new
		 * Customer("Dolor", 70000L, 71000d), new Customer("Mauris", 49000000L,
		 * 50000000d));
		 * 
		 * List<Customer> customers = Arrays.asList(new Customer("Acme",1000000L,5000d),
		 * new Customer("Lorem",2000000L,9000d), new Customer("Ipsum",3000000L,20000d));
		 * 
		 * System.out.println(customers); Collections.sort(customers);
		 * System.out.println(customers); Long totalImpressions = 32356000L; Long
		 * initialImpressions = 32356000L; Long totalImpressions = 50000000L; Long
		 * initialImpressions = 50000000L;
		 * 
		 * Long totalImpressions = 2000000000L; Long initialImpressions = 2000000000L;
		 * 
		 * Long remainingImpressions = 0L; Long totalImpressionsUsed = 0L;
		 * 
		 * Integer totalRevenue = 0;
		 * 
		 * for(int i = 0 ; i < customers.size() ; i++) {
		 * 
		 * Customer currentCust = customers.get(i); Long campaignTobeGiven =
		 * totalImpressions / currentCust.getImpressionsPerCampaign(); Long
		 * noOfImpressionTobeGiven = currentCust.getImpressionsPerCampaign() *
		 * campaignTobeGiven; remainingImpressions = totalImpressions %
		 * currentCust.getImpressionsPerCampaign();
		 * 
		 * if(i+1 < customers.size()) { Customer nextCust = customers.get(i+1);
		 * if(campaignTobeGiven > 1 && remainingImpressions > 0 && remainingImpressions
		 * < nextCust.getImpressionsPerCampaign()) { campaignTobeGiven =
		 * campaignTobeGiven - 1; noOfImpressionTobeGiven =
		 * currentCust.getImpressionsPerCampaign() * campaignTobeGiven; totalImpressions
		 * = totalImpressions - noOfImpressionTobeGiven; } else { totalImpressions =
		 * totalImpressions - noOfImpressionTobeGiven; } }
		 * currentCust.setCampaignTobeGiven(campaignTobeGiven.intValue());
		 * currentCust.setImpressionsTobeGiven(noOfImpressionTobeGiven);
		 * 
		 * totalRevenue = totalRevenue + currentCust.getTotalRevenue(); }
		 * 
		 * totalImpressionsUsed = initialImpressions - totalImpressions;
		 * 
		 * System.out.println(customers); System.out.println("Total Impressions Used : "
		 * + totalImpressionsUsed); System.out.println("Remaining Impressions: " +
		 * totalImpressions); System.out.println("Total Revenue : "+ totalRevenue);
		 */
	}

}
