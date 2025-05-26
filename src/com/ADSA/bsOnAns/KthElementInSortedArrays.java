package com.ADSA.bsOnAns;

public class KthElementInSortedArrays {
    public static int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) return kthElement(b, a, k);

        int n = a.length, m = b.length;
        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int l1 = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int l2 = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int r1 = (cutA == n) ? Integer.MAX_VALUE : a[cutA];
            int r2 = (cutB == m) ? Integer.MAX_VALUE : b[cutB];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return -1; // Should never reach here if inputs are valid
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(a, b, k)); // Output: 6

        int[] a2 = {100, 112, 256, 349, 770};
        int[] b2 = {72, 86, 113, 119, 265, 445, 892};
        int k2 = 7;
        System.out.println(kthElement(a2, b2, k2)); // Output: 256
    }
}
