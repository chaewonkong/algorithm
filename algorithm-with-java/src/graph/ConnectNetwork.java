package graph;

import java.util.Scanner;

// TODO: MST, 크루스칼 알고리즘

public class ConnectNetwork {
    private static int[][] arr;
    private static boolean[] isVisited;
    private static int M, N, cost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][N];
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() -1;
            int b = sc.nextInt() -1;
            int cost = sc.nextInt();

            arr[a][b] = cost;
            arr[b][a] = cost;
        }

        for (int i = 0; i < N; i++) {
            isVisited = new boolean[N];
            cost = 0;
            dfs(i);
            minCost = Math.min(cost, minCost);
        }

        System.out.println(minCost);
    }

    private static void dfs(int idx){
        // 탈출조건
        isVisited[idx] = true;

        for (int i = 0; i < N; i++) {
            if (i != idx && !isVisited[i] && arr[idx][i] > 0) {
                cost += arr[idx][i];
                dfs(i);
            }
        }

        // for문으로 dfs 재귀호출
    }
}
