package kakao2021internship;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Distancing {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] ans =  new int[n];

        for (int i = 0; i <n; i++) {
            ans[i] = checkDistancing(places[i]) ? 1 : 0;
        }

        return ans;
    }

    private boolean checkDistancing(String[] place) {
        int n = place.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (place[i].charAt(j) == 'P' && !bfs(new Point(i, j), place)) {
                    return false;
                }
            }
        }
        return true;
    }

//    public int[] solution(String[][] places) {
//        int[] answer = new int[places.length];
//
//        for (int i = 0; i < 5; i++) {
//            String[] place = places[i];
//            boolean flag = true;
//
//            for (int r = 0; r < 5 && flag; r++) {
//                for (int c = 0; c < 5; c++) {
//                    if (place[r].charAt(c) == 'P') {
//                        if (!bfs(new Point(r, c), place)) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
//            }
//
//            answer[i] = flag ? 1 : 0;
//        }
//
//        return answer;
//    }

    private boolean bfs(Point point, String[] place) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 제외조건
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == point.x && ny == point.y)) {
                    continue;
                }

                int d = Math.abs(nx - point.x) + Math.abs(ny - point.y);
                char target = place[nx].charAt(ny);


                if (place[nx].charAt(ny) == 'P' && d <= 2) {
                    return false;
                } else if (place[nx].charAt(ny) == 'O' && d < 2){
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return true;
    }

    /**
     *
     private boolean bfs(int r, int c, String[] place) {
     int[] dr = {-1, 1, 0, 0};
     int[] dc = {0, 0, -1, 1};

     Queue<int[]> queue = new LinkedList<int[]>();
     queue.add(new int[] {r, c});

     while (!queue.isEmpty()) {
     int[] pos = queue.poll();

     for (int i = 0; i < 4; i++) {
     int nr = pos[0] + dr[i];
     int nc = pos[1] + dc[i];

     if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c)) {
     continue;
     }

     int d = Math.abs(nr - r) + Math.abs(nc - c);
     if (place[nr].charAt(nc) == 'P' && d <= 2) {
     return false;
     } else if (place[nr].charAt(nc) == 'O' && d < 2){
     queue.add(new int[] {nr, nc});
     }
     }
     }

     return true;
     }
     */
//
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
