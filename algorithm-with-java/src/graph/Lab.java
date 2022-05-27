package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 연구소
 * source: https://www.acmicpc.net/problem/14502
 * 풀이: 1) DFS로 벽을 세운다 -> 2) BFS로 바이러스를 퍼뜨린다. -> 3) 안전 영역을 카운트한다
 * 시간복잡도: v^4. 정점의 수가 64개이므로 64^4
 */
public class Lab {
    static int result = Integer.MIN_VALUE;
    static int[][] arr;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
    }


    /**
     * DFS 를 통해 벽을 세우는 모든 가짓수를 탐색
     * @param depth 세운 벽의 개수 (depth <= 3)
     */
    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    /**
     * BFS 를 통해 바이러스를 전파시켜보고, 안전영역을 센다.
     */
    private static void bfs() {
        int[][] arrCopied = new int[n][m];
        Queue<Virus> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // Copy arr to arrCopied
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, arrCopied[i], 0, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrCopied[i][j] == 2) {
                    queue.add(new Virus(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Virus v = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arrCopied[nx][ny] == 0) {
                        arrCopied[nx][ny] = 2;
                        queue.add(new Virus(nx, ny));
                    }
                }
            }
        }

        // 바이러스 전파가 끝났다면 안전영역을 탐색
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrCopied[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(count, result);
    }

    private static class Virus{
        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
