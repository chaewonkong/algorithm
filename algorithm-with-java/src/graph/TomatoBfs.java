package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoBfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];
        Queue<Tomato> queue = new LinkedList<>();
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int target = sc.nextInt();
                arr[i][j] = target;

                if (target == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }

        // bfs로 토마토 익혀 나가기
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arr[nx][ny] == 0) {
                        queue.add(new Tomato(nx, ny));
                        arr[nx][ny] = arr[t.x][t.y] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                   return;
                } else {
                    min = Math.max(min, arr[i][j]);
                }
            }
        }
        System.out.println(min - 1);
        sc.close();
    }

    static class Tomato{
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}