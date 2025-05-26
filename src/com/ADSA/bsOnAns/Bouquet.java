package com.ADSA.bsOnAns;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.zip.ZipInputStream;

public class Bouquet {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,12,7,7};
        System.out.println(2%5);
//        System.out.println(minDays(arr,2,3));
    }

    private static int minDays(int[] arr, int m , int k){
        int s = Arrays.stream(arr).min().getAsInt();
        int e = Arrays.stream(arr).max().getAsInt();
        if(m*k>arr.length) return -1;
        while (s<=e){
            int mid = s+(e-s)/2;
            if(isPossible(arr,mid,m,k)){
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        return s;
    }
    private static boolean isPossible(int[] arr, int day, int m, int k){
        int count = 0;
        int No_of_bouquet = 0;
        for(int i : arr){
            if(i<=day){
                count++;
            }
            else{
                No_of_bouquet += count/k;
                count = 0;
            }
        }
        No_of_bouquet += count/k;
        return No_of_bouquet >= m;
    }
}
