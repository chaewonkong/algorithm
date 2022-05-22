package KakaoWinterInternship2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/** 다시 보면 좋을 문제
 * 문자열 파싱과 커스터마이징된 정렬 알고리즘
 */

public class Tuple {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length() - 2).replace("},{", "/").split("/");
        ArrayList<Integer> resultList = new ArrayList<>();

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
                if (!resultList.contains(val)) {
                    resultList.add(val);
                }
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

