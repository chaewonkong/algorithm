package kakao2021internship;

import java.util.HashMap;
import java.util.Map;

public class NumberStringAndNumber {
    public int solution(String s) {

        Map<String, Integer> map =  new HashMap<>(){{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();

            s = s.replaceAll(key, Integer.toString(val));
        }

        return Integer.parseInt(s);
    }
}
