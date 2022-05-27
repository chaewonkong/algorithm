package string;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SortingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        String[] arr = new String[n];
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        String[] arr = set.toArray(String[]::new);

        Arrays.sort(arr, (o1, o2) -> compareString(o1, o2));
        for (String s : arr) {
            System.out.println(s);
        }
        sc.close();
    }

    private static int compareString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        return 0;
    }
}
