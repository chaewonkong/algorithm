package string;

import java.util.Scanner;

/**
 * 팰린드롬인지 확인하기
 * https://www.acmicpc.net/problem/10988
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w = sc.nextLine();
        boolean isPalindrome = true;

        int i = 0;
        int j = w.length() - 1;

        while (i < j) {
            if (w.charAt(i) != w.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(isPalindrome ? 1 : 0);

        sc.close();
    }
}
