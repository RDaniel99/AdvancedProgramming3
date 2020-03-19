package com.company;

public class Main {

    public static void main(String[] args) {
	    Knapsack k = new Knapsack();

	    System.out.println("Initial items:");
	    k.printItems();
	    System.out.println();

		long startTimeGreedy = System.nanoTime();
		k.useGreedy();
		long stopTimeGreedy = System.nanoTime();

		long startTimeDynamic = System.nanoTime();
		k.useDynamic();
		long stopTimeDynamic = System.nanoTime();

		System.out.println();
		System.out.println("---------- TIMES -----------");
		System.out.println("Greedy : " + (stopTimeGreedy - startTimeGreedy) + " nanoseconds");
		System.out.println("Dynamic: " + (stopTimeDynamic - startTimeDynamic) + " nanoseconds");

		System.out.println();
		k.statistics();
    }
}
