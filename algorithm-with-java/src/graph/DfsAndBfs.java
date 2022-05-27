package graph;

import java.util.*;

public class DfsAndBfs {

    static boolean[] isVisited;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        isVisited = new boolean[N+1];

        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");

        // init isVisited
        Arrays.fill(isVisited, false);

        bfs(V);
        System.out.println(sb.toString());
    }

    public static void dfs(int idx){
        isVisited[idx] = true;
        sb.append(idx).append(" ");

        for (int i =0; i < isVisited.length; i++) {
            if (i != idx && !isVisited[i] && arr[idx][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(idx);
        isVisited[idx] = true;

        while(!queue.isEmpty()){
            int v = queue.poll();
            sb.append(v).append(" ");

            for (int i = 0; i < isVisited.length; i++) {
                if (i != v && !isVisited[i] && arr[v][i] == 1) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
