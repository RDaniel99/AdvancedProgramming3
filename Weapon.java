package com.company;

public class Weapon implements Item {
    enum WeaponType {
        Gun,
        Knife,
        Bazuka
    }

    private WeaponType type;
    private double value;
    private double weight;

    public void setType(WeaponType type) {
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
        if(type == WeaponType.Gun) {
            return "Gun";
        }

        if(type == WeaponType.Knife) {
            return "Knife";
        }

        if(type == WeaponType.Bazuka) {
            return "Bazuka";
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
