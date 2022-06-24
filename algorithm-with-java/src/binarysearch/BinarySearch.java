package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinarySearch {
    static int binarySearch(int[] arr, int key, int start, int end) {
        int mid = (start + end) / 2;
        // 탈출조건
        if (start == end) {
            return mid;
        }

        if (arr[mid] >= key) {
            return binarySearch(arr, key, start, mid);
        } else {
            return binarySearch(arr, key, mid+1, end);
        }
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 3, 5, 7, 9};
        int key = 3;
        int N = 5;

        int result = binarySearch(arr, key, 0, N-1);
        System.out.println("result = " + result);
    }
}
