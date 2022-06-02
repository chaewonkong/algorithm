package line2022sumerinternship;

import java.util.*;

public class Rocket {
    Set<Integer> longestJourney;
    private static int[] ships;
    private static int[] distance;
    public int solution(int fuel, int[] powers, int[] distances) {
        int r = powers.length;
        int min = Integer.MAX_VALUE;
        longestJourney = new HashSet<>();
        ships = powers;
        distance = distances;
        boolean[] visited = new boolean[fuel];
        Arrays.fill(visited, false);


        permutations(fuel, r,visited, new Stack<>());
        for (int time : longestJourney) {
            min = Math.min(min, time);
        }
        return min;
    }

    private void permutations(int n, int r,boolean[] visited, Stack<Integer> selected) {
        // nPr
        // 각 우주선 소요시간 중 가장 긴 시간을 배열에 담는다.
        if (r == 0) {
            // 연료가 0인 것이 있다면 바로 탐색 종료
            if (selected.stream().anyMatch(i -> i == 0)) {
                return;
            }
            longestJourney.add(getLongestJourney(selected));
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.push(i);
                permutations(n, r - 1, visited, selected);
                selected.pop();
                visited[i] = false;
            }
        }
    }

    private int getLongestJourney(Stack<Integer> selected) {
        int max = Integer.MIN_VALUE;
        int[] fuels = selected.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < ships.length; i++) {
            int journey = getJourney(ships[i], distance[i], fuels[i]);
            max = Math.max(journey, max);
        }

        return max;
    }

    private int getJourney(int p, int d, int m) {
        int dist = 0;
        int vel = 0;
        int time = 0;

        // 연료로 등가속운동
        while (m > 0) {
            vel += p;
            dist += vel;
            m--;
            time += 1;
        }

        // 연료 고갈
        while (dist < d) {
            dist += vel;
            time += 1;
        }

        return time;
    }
}
