package com.company;

import java.util.*;

public class Greedy implements Algorithm {
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
        //items.sort((i1,i2)->i1.profitFactor()>i2.profitFactor()?-1:0);

        for(int i = 0; i < items.size(); i++) {
            for(int j = i + 1; j < items.size(); j++) {
                if(items.get(i).profitFactor() < items.get(j).profitFactor()) {
                    ItemWrapper aux = new ItemWrapper();
                    aux.it = items.get(i);
                    items.set(i, items.get(j));
                    items.set(j, aux.it);
                }
            }
        }

        double w = 0;
        double v = 0;
        int pos = 0;
        while(pos < items.size() && w < knapsackWeight) {
            if(w + items.get(pos).getWeight() > knapsackWeight) {
                pos++;
                continue;
            }

            w += items.get(pos).getWeight();
            v += items.get(pos).getValue();
            pos++;
        }

        finalValue = v;
        finalWeight = w;
        System.out.println("Using Greedy, we obtained weight = " + w + " and value = " + v);
        System.out.println("Items selected:");

        for(int i = 0; i < pos; i++) {
            items.get(i).printItem();
        }

        System.out.println();
    }

    @Override
    public void setItems(ArrayList<Item> arrayList) {
        items = arrayList;
    }
}
