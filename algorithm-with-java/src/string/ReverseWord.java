package string;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        // iterate 하는 동안 태그를 만나면 sb에 추가.
        int i = 0;
        while (i < s.length()) {
            StringBuilder temp = new StringBuilder();
            if (s.charAt(i) == '<') {
                while (s.charAt(i) != '>') {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append(s.charAt(i));
                i++;
            } else if (s.charAt(i) == ' ') {
                sb.append(s.charAt(i));
                i++;
            }  else {
                // 단어일 때
                while (i < s.length() && s.charAt(i) != '<' && s.charAt(i) != ' ') {
                    temp.append(s.charAt(i));
                    i++;
                }
                sb.append(reverseWord(temp));
            }
        }

        System.out.println(sb);
    }

    private static String reverseWord(StringBuilder s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
