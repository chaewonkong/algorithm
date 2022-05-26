package Lis;

import java.util.*;

public class Lis5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lis = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] index = new int[N];
        int[] arr = new int[N];
        lis.add(Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();
            arr[i] = target;
            if (lis.get(lis.size() - 1) < target) {
                lis.add(target);
                index[i] = lis.size() - 1;
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
                index[i] = end;
            }
        }

        // 역탐색을 통해 가장 긴 증가하는 부분 수열 구하기
        int count = lis.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int j = N - 1; j >= 0; j--) {
            if (index[j] == count) {
                stack.push(arr[j]);
                count--;
            }
        }

        while (stack.size() > 0) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(lis.size() - 1);
        System.out.println(sb);
    }
}
