package com.ADSA.bsOnAns;

import java.util.Arrays;

public class shipPackages {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(arr,5));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int s=Arrays.stream(weights).max().getAsInt();
        int e = Arrays.stream(weights).sum();
        while(s<=e){
            int m = s+(e-s)/2;
            if(totalDays(weights,m) <= days){
                e = m-1;
            }
            else{
                s=m+1;
            }
        }
        return s;
    }

    private static int totalDays(int[] arr, int capacity){
        int days = 1;
        int load = 0;
        for(int i : arr){
            if(load+i>capacity) {
                days = days + 1;
                load = i;
            }
            else {
                load+=i;
            }
        }
        return days;
    }
}
