package permutation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EveryPermutation {
    public static void main(String[] args) {
        // nPn using DFS
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        // Fill Array
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        Arrays.fill(visited, false);


        permutation(arr, new Stack<>(), visited, n, n);
    }

    private static void permutation(int[] targetArr, Stack<Integer> selection, boolean[] visited, int n, int left) {
        if (left == 0) {
            StringBuilder sb = new StringBuilder();
            for (int selected : selection) {
                sb.append(selected).append(" ");
            }
            System.out.println(sb);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selection.push(targetArr[i]);
                permutation(targetArr, selection, visited, n, left - 1);
                selection.pop();
                visited[i] = false;
            }
        }
    }
}
//    private static void permutation(int length, Stack<Integer> picked, int left) {
//        if (left == 0) {
//            System.out.println(picked);
//            return;
//        }
//
//        int target = picked.isEmpty() ? 0 : picked.peek() + 1;
//
//        for (int next = target; next < length; next++) {
//            picked.push(next);
//            permutation(length, picked, left - 1);
//            picked.pop();
//        }
//    }
//}
