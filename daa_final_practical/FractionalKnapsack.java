package daa_final_practical;

import java.util.*;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {

    static void fractionalKnapsack() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        double res = 0.0;

        List<Item> items = new ArrayList<>();

        // Pairing weights and values
        for (int i = 0; i < weights.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        // Sort items by value/weight ratio in descending order
        Collections.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        for (Item item : items) {
            if (capacity <= 0)
                break;

            if (item.weight > capacity) { // Take fractional part
                res += capacity * ((double)item.value / item.weight);
                capacity = 0;
            } else { // Take whole item
                res += item.value;
                capacity -= item.weight;
            }
        }

        System.out.println("Maximum value in Knapsack = " + (int)res);
    }

    public static void main(String[] args) {
        fractionalKnapsack();
    }
}

