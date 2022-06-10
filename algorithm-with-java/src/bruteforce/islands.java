package bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class islands {
    private static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            arr = new int[n][m];
            int count = 0;

            if (m == 0 && n == 0) {
                break;
            }

            // 지도 배열 생성
            for (int i  = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                   int target = sc.nextInt();
                    arr[i][j] = target;
                }
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    // 섬 여부를 탐색
                    if (isIsland(x, y, m, n)) {
                        count++;
                    }
                }
            }

            // Do something
            System.out.println(count);
        }
    }

    private static boolean isIsland(int x, int y, int m, int n) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

        Queue<Island> queue = new LinkedList<>();

        // 육지가 아니면 섬이 아니다
        if (arr[y][x] != 1) {
            return false;
        }

        queue.add(new Island(x, y));

        while(!queue.isEmpty()) {
            // 주변에 육지가 없어질 때까지 탐색을 진행
            Island island = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = island.x + dx[i];
                int ny = island.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    // 상하좌우 대각선 모두 바다가 아니면 섬이 아니다
                    // TODO: 섬이 아닌 경우, 그 섬을 대상으로 다시 탐색을 진행.
                    if (arr[ny][nx] != 0) {
                        queue.add(new Island(nx, ny));
                    }
                }
            }

            // 사방 탐색 결과 섬으로 밝혀진 경우
            // TODO: 방문했는지 여부를 저장할 수 있게 visited 배열 생성

        }


        return true;
    }

    private static class Island{
        int x, y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
