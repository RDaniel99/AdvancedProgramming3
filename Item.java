package com.company;

class ItemWrapper {
    public Item it;
}

public interface Item {
    String getName();

    double getValue();

    double getWeight();

    default double profitFactor() {
        return getValue() / getWeight();
    }

    default void printItem() {
        System.out.println("Item " + getName() + " with weight = " + getWeight() + " and value = " + getValue());
    }
}
