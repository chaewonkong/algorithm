package KakaoWinterInternship2019;

/**
 * Binary Search
 */

public class Bridge {
    public int solution(int[] stones, int k) {
        int count = 0;
        int end = 200000000;
        int start = 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (!crossable(stones, mid, k)) {
                // 더 적은 인원만 건널 수 있다
                end = mid - 1;
            } else {
                // 더 많은 인원이 건널 수 있다
                count = Math.max(count, mid);
                start = mid + 1;
            }
        }
        return count;
    }



    private boolean crossable(int[] stones, int expected, int k) {
        int jumpCount = 0;

        for (int stone : stones) {
            if (stone - expected < 0) {
                jumpCount++;
            } else {
                jumpCount = 0;
            }
            if (jumpCount == k) {
                return false;
            }
        }

        return true;
    }
}
