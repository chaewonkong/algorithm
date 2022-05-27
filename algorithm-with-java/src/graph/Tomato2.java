package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato2 {
    static Queue<Dot> queue = new LinkedList<>();
    static int[][] arr;
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    queue.add(new Dot(i, j, 0));
                }
            }
        }

        bfs();
    }

    static void bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int day = 0;

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            day = dot.day;
            for (int i = 0; i < dx.length; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        queue.add(new Dot(nx, ny, day + 1));
                    }
                }
            }
        }

        if (!checkTomato()){
            System.out.println(-1);
        } else {
            System.out.println(day);
        }

    }

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}

class Dot {
    int x;
    int y;
    int day;

    public Dot(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
