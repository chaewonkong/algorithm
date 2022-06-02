package line2022sumerinternship;

import java.util.*;

public class WellKnown {
    public String[] solution(String[] logs) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> user = new HashSet<>();
        ArrayList<String> wellknownList = new ArrayList<>();

        // 배열을 순회하며 문자열 파싱
        for (String log : logs) {
            String[] log_arr = log.split(" ");
            String name = log_arr[0];
            String key = log_arr[1];

            Set<String> target = map.getOrDefault(key, new HashSet<>());
            target.add(name);
            map.put(key, target);

            user.add(name);
        }

        int half = user.size() % 2 == 0 ? user.size() / 2 : user.size() / 2 + 1;
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= half) {
                wellknownList.add(entry.getKey());
            }
        }

        String[] answer = wellknownList.toArray(new String[0]);
        Arrays.sort(answer);

        return answer;
    }
}
