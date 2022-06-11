package string;

import java.util.Scanner;

public class ContinuingSection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String s = sc.nextLine();
            System.out.println(maxContinuingSection(s));
        }
    }

    private static int maxContinuingSection(String s) {
        int max = 0;
        int i = 0;
        while (i < s.length() - 1) {
            int count = 1;
            char c = s.charAt(i);

            while (i < s.length() - 1 && c == s.charAt(i+1)) {
                count++;
                i++;
            }
            max = Math.max(max, count);
            i++;
        }

        return max == 0 ? 1 : max;
    }
}
