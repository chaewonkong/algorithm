package line2022sumerinternship;

public class Cutting {
    private static int min;
    private static int[] time;
    public int solution(int n, int[] times) {
        min = Integer.MAX_VALUE;
        time = times;
        dfs(0, 1, n);
        return min;
    }

    private void dfs(int duration, int count, int n) {
        if (count == n) {
            min = Math.min(min, duration);
            return;
        }
        if (count > n) {
            return;
        }

        if (duration == 0) {
            dfs(duration + time[0], count + 1, n);
            return;
        }

        dfs(duration + time[0], count + 1, n);
        if (count <= time.length) {
            dfs(duration + time[count - 1], count * 2, n);
        }
    }
}
