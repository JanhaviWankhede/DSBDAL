package daa_final_practical;

public class FibonacciExample {

    // Recursive Fibonacci
    static int recursiveFibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    // Non-Recursive Fibonacci
    static void nonRecursiveFibonacci(int n) {
        int first = 0, second = 1;
        System.out.println(first);
        System.out.println(second);

        while (n - 2 > 0) {
            int third = first + second;
            first = second;
            second = third;
            System.out.println(third);
            n--;
        }
    }

    public static void main(String[] args) {
        int n = 10;

        // Recursive Fibonacci
        System.out.println("Recursive Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.println(recursiveFibonacci(i));
        }

        // Non-Recursive Fibonacci
        System.out.println("\nNon-Recursive Fibonacci:");
        nonRecursiveFibonacci(n);
    }
}
