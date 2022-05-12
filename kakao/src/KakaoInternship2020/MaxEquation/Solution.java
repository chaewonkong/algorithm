package KakaoInternship2020.MaxEquation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[] order = new String[]{
                "+-*",
                "+*-",
                "*-+",
                "*+-",
                "-+*",
                "-*+"
        };
        ArrayList<Character> operators = new ArrayList<Character>();
        for (int k = 0; k < expression.length(); k++) {
            char c = expression.charAt(k);
            if (c == '*' || c == '+' || c == '-') {
                operators.add(c);
            }
        }
        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(Arrays.stream(expression.split("\\D")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());

        for (String s : order) {
            ArrayList<Long> numbersCopied =  new ArrayList<Long>();
            for (Integer obj : numbers) {
                numbersCopied.add(obj.longValue()); //will automatically convert Int to Long
            }
            ArrayList<Character> operatorsCopied = new ArrayList<>(operators);

            for (int i = 0; i < s.length(); i++) {
                char op = s.charAt(i);
                int j = 0;
                while (j < operatorsCopied.size()) {
                    if (operatorsCopied.get(j) == op) {
                        if (op == '*') {
                            Long n = numbersCopied.get(j) * numbersCopied.get(j + 1);
                            numbersCopied.set(j + 1, n);
                            numbersCopied.remove(j);
                            operatorsCopied.remove(j);
                        } else if (op == '+') {
                            Long n = numbersCopied.get(j) + numbersCopied.get(j + 1);
                            numbersCopied.set(j + 1, n);
                            numbersCopied.remove(j);
                            operatorsCopied.remove(j);
                        } else {
                            Long n = numbersCopied.get(j) - numbersCopied.get(j + 1);
                            numbersCopied.set(j + 1, n);
                            numbersCopied.remove(j);
                            operatorsCopied.remove(j);
                        }
                        // j를 낮춰줄 수 있는 방법이 필요함.
                        j = 0;
                    } else {
                        j++;
                    }
                }
            }
            answer = Math.max(Math.abs(numbersCopied.get(0)), answer);
        }
        return answer;
    }
}
