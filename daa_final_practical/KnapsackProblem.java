package daa_final_practical;

public class KnapsackProblem {

    // Recursive function to solve 0/1 Knapsack
    static int knapsack(int W, int n, int[] wt, int[] val) {
        // Base case
        if (n < 0 || W <= 0)
            return 0;

        // If weight of nth item is more than remaining capacity
        if (wt[n] > W)
            return knapsack(W, n - 1, wt, val);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) nth item not included
        else
            return Math.max(
                val[n] + knapsack(W - wt[n], n - 1, wt, val),
                knapsack(W, n - 1, wt, val)
            );
    }

    public static void main(String[] args) {
        int[] val = {50, 100, 150, 200}; // Values
        int[] wt = {8, 16, 32, 40};      // Weights
        int W = 64;                      // Capacity
        int n = val.length - 1;          // Last index

        int result = knapsack(W, n, wt, val);
        System.out.println("Maximum value in Knapsack = " + result);
    }
}
