package graph;

import java.util.Arrays;
import java.util.Scanner;

public class Virus {
    static int[][] arr;
    static int[] isVisited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        arr = new int[M + 1][M + 1];
        isVisited = new int[M + 1];
        Arrays.fill(isVisited, 0);

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);
        int result = Arrays.stream(isVisited).sum();
        System.out.println(result - 1);
    }

    static void dfs(int idx){
        isVisited[idx] = 1;

        for (int i = 0; i < isVisited.length; i++) {
            if (i != idx && isVisited[i] == 0 && arr[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}
