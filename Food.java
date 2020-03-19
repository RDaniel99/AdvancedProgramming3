package com.company;

public class Food implements Item {
    enum FoodType {
        Mar,
        Banana,
        Capsune
    }

    private FoodType type;
    private double value;
    private double weight;

    public void setType(FoodType type) {
        this.type = type;
    }

    public void setValue(double v) {
        this.value = v;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        if(type == FoodType.Mar) {
            return "Mar";
        }

        if(type == FoodType.Banana) {
            return "Banana";
        }

        if(type == FoodType.Capsune) {
            return "Capsune";
        }

        return null;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
