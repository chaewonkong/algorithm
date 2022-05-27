package combination;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Lottery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            // print all cases alphabetic order
            combination(arr, new Stack<>(), 6);
            System.out.println();
        }
        sc.close();
    }

    private static void combination(int[] arr, Stack<Integer> selection, int left) {
        if (left == 0) {
            StringBuilder sb = new StringBuilder();
            for (int item : selection) {
                sb.append(item).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            selection.push(arr[i]);
            combination(Arrays.copyOfRange(arr, i+1, arr.length), selection, left - 1);
            selection.pop();
        }
    }
}
