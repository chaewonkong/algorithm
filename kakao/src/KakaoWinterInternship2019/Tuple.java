package KakaoWinterInternship2019;

import java.util.*;

/** 다시 보면 좋을 문제
 * 문자열 파싱과 커스터마이징된 정렬 알고리즘
 */

public class Tuple {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length() - 2).split("\\}\\,\\{");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String subSet : arr) {
            String[] subSetArr = subSet.split(",");
            for (String numString: subSetArr) {
                int val = Integer.parseInt(numString);
                set.add(val);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

