package Greedy;

import java.util.*;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value/weight ratio (descending)
        Arrays.sort(items, (a, b) ->
                Double.compare((double) b.value / b.weight, (double) a.value / a.weight)                 // [60 , 100 , 200 , 100]
        );

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) break;  // no space left

            if (item.weight <= capacity) {
                // take whole item
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // take fractional part of item
                totalValue += ((double) item.value / item.weight) * capacity;
                capacity = 0;  // now full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(100, 20),
                new Item(60, 10),
                new Item(100, 50),
                new Item(200, 50)
        };

        int capacity = 90;
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
