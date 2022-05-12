package Permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        permutation(m, new Stack<>(), n);
    }

    private static void permutation(int length, Stack<Integer> picked, int left) {
        if (left == 0) {
            System.out.println(picked);
            return;
        }

        int target = picked.isEmpty() ? 0 : picked.peek() + 1;

        for (int next = target; next < length; next++) {
            picked.push(next);
            permutation(length, picked, left - 1);
            picked.pop();
        }
    }
}
