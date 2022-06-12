package fibonacci;

import java.util.Scanner;

public class Fibonacci5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }

    private static int fib(int n) {
        int[] cache = new int[21];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        int i = 3;

        while (i <= n) {
            cache[i] = cache[i-1] + cache[i-2];
            i++;
        }

        return cache[n];
    }
}
