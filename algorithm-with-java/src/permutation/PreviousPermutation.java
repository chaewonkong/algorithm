package permutation;

import java.util.ArrayList;
import java.util.Scanner;

public class PreviousPermutation {
    private static final ArrayList<StringBuilder> permutations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (hasPrevPermutation(arr, n)) {
            StringBuilder sb = new StringBuilder();
            for (int k : arr) {
                sb.append(k).append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }

   private static boolean hasPrevPermutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i] >= arr[i-1]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = n - 1;
        while (arr[i-1] <= arr[j]) {
            j--;
        }
        j = n - 1;
       swap(arr, i - 1, j);

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }


        return true;
   }

   private static void swap(int[] arr, int i, int j) {
       int tmp = arr[i];
       arr[i] = arr[j];
       arr[j] = tmp;
   }
}
