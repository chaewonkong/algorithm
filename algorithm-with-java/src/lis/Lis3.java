package lis;

import java.util.*;

public class Lis3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lis = new ArrayList<>();

        int N = sc.nextInt();
        lis.add(Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();
            if (lis.get(lis.size() - 1) < target) {
                lis.add(target);
            } else {
                // Binary Search 를 통해 바꿔치기할 위치를 탐색
                int start = 1;
                int end = lis.size() - 1;

                while (start < end) {
                    int mid = (start + end) / 2;
                    if (lis.get(mid) < target) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                lis.set(end, target);
            }
        }

        System.out.println(lis.size() - 1);
    }
}
