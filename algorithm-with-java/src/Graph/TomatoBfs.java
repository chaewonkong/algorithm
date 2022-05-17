package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoBfs {
    static Queue<Tomato> queue = new LinkedList<>();
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && arr[nx][ny] == 0) {
                    queue.add(new Tomato(nx, ny));
                    arr[nx][ny] = arr[tomato.x][tomato.y] + 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, arr[i][j]);
            }
        }

        if (result == 1) {
            return 0;
        }

        return result - 1;
    }
}

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}