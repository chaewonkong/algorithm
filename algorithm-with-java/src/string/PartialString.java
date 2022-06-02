package string;

import java.util.Scanner;

/** 부분 문자열
 * https://www.acmicpc.net/problem/16916
 */
public class PartialString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        String candidate = sc.nextLine();
        System.out.println(word.matches("\\*" + candidate + "."));
//        System.out.println(isSubString(word, candidate) ? 1 : 0);
        sc.close();
    }

    private static boolean isSubString(String origin, String sub) {
        if (origin.length() < sub.length()) {
            return false;
        }
        for (int i = 0; i < origin.length(); i++) {
            int j = 0;
            while (j < sub.length() && i + j < origin.length() && origin.charAt(i + j) == sub.charAt(j)) {
                // 매칭을 찾은 경우
                if (j == sub.length() - 1) {
                    return true;
                }
                j++;
            }
            if (i + j >= origin.length()) {
                break;
            }
        }

        return false;
    }
}
