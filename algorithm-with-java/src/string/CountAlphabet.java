package string;

import java.util.Scanner;

public class CountAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int[] alphabets = new int[26];
        for (int i = 0; i < word.length(); i++) {
            alphabets[word.charAt(i) - 97] += 1;
        }

        for (int count: alphabets) {
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}
