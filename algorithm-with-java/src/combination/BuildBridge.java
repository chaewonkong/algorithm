package combination;

import java.util.Scanner;

/**
 * mCn: 순서 상관 없이 m개 중 n개 선택
 */
public class BuildBridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            // print number of combinations
            System.out.println(combinations(m, n));
        }
    }

    private static int combinations(int m, int n) {
        if (n == 1) {
            return m;
        }

        if (m == n) {
            return 1;
        }
        return combinations(m - 1, n - 1) + combinations(m - 1, n);
    }
}
