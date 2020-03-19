package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Knapsack {
    ArrayList<Item> items;

    private double finalValueDyn;
    private double finalWeightDyn;

    private double finalValueGreedy;
    private double finalWeightGreedy;

    public double getFinalValueDyn() {
        return finalValueDyn;
    }

    public double getFinalValueGreedy() {
        return finalValueGreedy;
    }

    public double getFinalWeightDyn() {
        return finalWeightDyn;
    }

    public double getFinalWeightGreedy() {
        return finalWeightGreedy;
    }

    public Knapsack() {
        items = new ArrayList<Item>();

        Weapon w = new Weapon();
        w.setType(Weapon.WeaponType.Gun);
        w.setValue(2.0);
        w.setWeight(1.0);

        Book b = new Book();
        b.setType(Book.BookType.Comedie);
        b.setValue(2.0);
        b.setWeight(1.0);

        Food f = new Food();
        f.setWeight(1.0);
        f.setValue(3.0);
        f.setType(Food.FoodType.Banana);

        // f w b
        // f b w
        // w f b
        // w b f
        // b f w
        // b w f

        items.add(b);
        items.add(f);
        items.add(w);
        /*
        items.add(generateRandomItem());
        items.add(generateRandomItem());
        items.add(generateRandomItem());*/
    }

    private Item generateRandomItem() {
        Random random = new Random();
        int type = random.nextInt(3);

        if(type == 0) {
            Weapon w = new Weapon();
            int nxtRand = random.nextInt(3);

            if(nxtRand == 0) {
                w.setType(Weapon.WeaponType.Gun);
            }

            if(nxtRand == 1) {
                w.setType(Weapon.WeaponType.Knife);
            }

            if(nxtRand == 2) {
                w.setType(Weapon.WeaponType.Bazuka);
            }

            w.setValue((double)random.nextInt(10));
            w.setWeight((double)random.nextInt(10) + 1);

            return w;
        }

        if(type == 1) {
            Book b = new Book();
            int nxtRand = random.nextInt(3);

            if(nxtRand == 0) {
                b.setType(Book.BookType.Comedie);
            }

            if(nxtRand == 1) {
                b.setType(Book.BookType.Roman);
            }

            if(nxtRand == 2) {
                b.setType(Book.BookType.Drama);
            }

            b.setValue(random.nextInt(10));
            //(int)Math.random()*10
            b.setWeight((double)random.nextInt(10) + 1);

            return b;
        }

        Food f = new Food();
        int nxtRand = random.nextInt(3);

        if(nxtRand == 0) {
            f.setType(Food.FoodType.Banana);
        }

        if(nxtRand == 1) {
            f.setType(Food.FoodType.Capsune);
        }

        if(nxtRand == 2) {
            f.setType(Food.FoodType.Mar);
        }

        f.setValue((double)random.nextInt(10));
        f.setWeight((double)random.nextInt(10) + 1);

        return f;
    }

    public void printItems() {
        for (Item item : items) {
            item.printItem();
        }
    }

    public void useGreedy() {
        Greedy greedy = new Greedy();
        greedy.setItems(items);
        greedy.setKnapsackWeight(10);
        greedy.execute();

        finalValueGreedy = greedy.getFinalValue();
        finalWeightGreedy = greedy.getFinalWeight();
    }

    public void useDynamic() {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        dynamicProgramming.setItems(items);
        dynamicProgramming.setKnapsackWeight(10);
        dynamicProgramming.execute();

        finalValueDyn = dynamicProgramming.getFinalValue();
        finalWeightDyn = dynamicProgramming.getFinalWeight();
    }

    public void statistics() {
        System.out.println("------- STATISTICS --------");
        if(finalWeightDyn < finalWeightGreedy) {
            double percentage = 100.0 - finalWeightDyn / finalWeightGreedy* 100.0;
            System.out.println("DP obtained better weight than Greedy (" + percentage + "% better)");
        }
        else if(finalWeightDyn == finalWeightGreedy) {
            System.out.println("They obtained the same weight");
        }
        else {
            double percentage = 100.0 - finalWeightGreedy / finalWeightDyn * 100.0;
            System.out.println("Greedy obtained better weight than DP (" + percentage + "% better)");
        }

        if(finalValueDyn > finalValueGreedy) {
            double percentage = 100.0 - finalValueGreedy / finalValueDyn * 100.0;
            System.out.println("DP obtained better value than Greedy (" + percentage + "% better)");
        }
        else if(finalValueDyn == finalValueGreedy) {
            System.out.println("They obtained the same value");
        }
        else {
            double percentage = 100.0 - finalValueGreedy / finalValueDyn * 100.0;
            System.out.println("Greedy obtained better value than DP (" + percentage + "% better)");
        }
    }
}
