package com.ADSA.bsOnAns;

public class kth {
        public static int findMedian(int[][] matrix) {
            int r = matrix.length, c = matrix[0].length;
            int low = 1, high = 2000;

            while (low <= high) {
                int mid = (low + high) / 2;
                int count = 0;

                for (int i = 0; i < r; i++) {
                    count += countSmallerEqual(matrix[i], mid);
                }

                if (count <= (r * c) / 2) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return low;
        }

        // Binary search to count elements <= mid in a row
        private static int countSmallerEqual(int[] row, int target) {
            int l = 0, h = row.length - 1;
            while (l <= h) {
                int m = (l + h) / 2;
                if (row[m] <= target) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return l;
        }

        public static void main(String[] args) {
            int[][] mat1 = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
            System.out.println(findMedian(mat1)); // Output: 5

            int[][] mat2 = {{1}, {2}, {3}};
            System.out.println(findMedian(mat2)); // Output: 2

            int[][] mat3 = {{3}, {5}, {8}};
            System.out.println(findMedian(mat3)); // Output: 5
        }
    }


