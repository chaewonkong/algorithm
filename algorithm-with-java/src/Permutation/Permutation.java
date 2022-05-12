package Permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        permutation(4, new ArrayList<Integer>(), 2);
    }

    private static void permutation(int n, List<Integer> picked, int left) {
        if (left == 0) {
            System.out.println(picked);
            return;
        }

        int target = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;

        for (int next = target; next < n; next++) {
            picked.add(next);
            permutation(n, picked, left - 1);
            picked.remove(picked.size() - 1);
        }
    }
}
