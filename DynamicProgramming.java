/**
 * We have to assume that all numbers are INTEGERS
 */


package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicProgramming implements Algorithm{
    private ArrayList<Item> items;
    private double knapsackWeight;
    private double finalValue;
    private double finalWeight;

    public double getFinalValue() {
        return finalValue;
    }

    public double getFinalWeight() {
        return finalWeight;
    }

    public void setKnapsackWeight(double knapsackWeight) {
        this.knapsackWeight = knapsackWeight;
    }

    @Override
    public void execute() {
        double[] dp = new double[(int)knapsackWeight + 2];
        boolean[] go = new boolean[(int)knapsackWeight + 2];
        Item[] prec = new Item[(int)knapsackWeight + 2];

        go[0] = true;

        double maximumValue = -1;
        int positionMaximum = -1;
        for(Item item: items) {

            int weight = (int)item.getWeight();
            int value = (int)item.getValue();

            for(int w = (int)knapsackWeight - weight; w >= 0; w--) {
                if(go[w] && (dp[w + weight] < dp[w] + value || !go[w + weight])) {
                    dp[w + weight] = dp[w] + value;
                    prec[w + weight] = item;
                    go[w + weight] = true;

                    if(dp[w + weight] > maximumValue) {
                        maximumValue = dp[w + weight];
                        positionMaximum = w + weight;
                    }
                }
            }
        }

        finalValue = maximumValue;
        finalWeight = positionMaximum;
        System.out.println("Using Dynamic Programming, we obtained weight = " + positionMaximum + " and value = " + maximumValue);
        System.out.println("Items selected:");
        while(positionMaximum != 0) {
            prec[positionMaximum].printItem();
            positionMaximum -= prec[positionMaximum].getWeight();
        }

        System.out.println();
    }

    @Override
    public void setItems(ArrayList<Item> arrayList) {
        items = arrayList;
    }
}
