package com.ADSA.bsOnAns;

import java.util.Arrays;

public class KokoBanana {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        System.out.println(minSpeed(arr,8));
    }

    public static int minSpeed(int[] piles, int h){
        int s = 1, e = Arrays.stream(piles).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while(s<=e){
            int m = s+(e-s)/2;
            long total_hrs = time(piles,m);
            if(total_hrs<=h){
                ans = m;
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return ans;
    }

    private static long time(int[] arr, int speed){
        long total = 0;
        for(int i : arr){
            total += (i+speed-1)/speed;
        }
        return total;
    }
}
