package com.company;

public class Book implements Item {
    enum BookType {
        Roman,
        Comedie,
        Drama
    }

    private BookType type;
    private double value;
    private double weight;

    public void setType(BookType type) {
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
        if(type == BookType.Roman) {
            return "Roman";
        }

        if(type == BookType.Comedie) {
            return "Comedie";
        }

        if(type == BookType.Drama) {
            return "Drama";
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
