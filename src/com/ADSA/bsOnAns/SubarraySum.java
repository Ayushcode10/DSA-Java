package com.ADSA.bsOnAns;

import java.util.*;

public class SubarraySum {

    public static List<Integer> findSubarray(int[] arr, int sum) {
        int start = 0, currSum = 0;
        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];

            while (currSum > sum && start < end) {
                currSum -= arr[start++];
            }

            if (currSum == sum) {
                return Arrays.asList(start + 1, end + 1); // 1-based indexing
            }
        }
        return Arrays.asList(-1);
    }

    public static void main(String[] args) {
        System.out.println(findSubarray(new int[]{1, 2, 3, 7, 5}, 12)); // [2, 4]
        System.out.println(findSubarray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15)); // [1, 5]
        System.out.println(findSubarray(new int[]{5, 3, 4}, 2)); // [-1]
    }
}

