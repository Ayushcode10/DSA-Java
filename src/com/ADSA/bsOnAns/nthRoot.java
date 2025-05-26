package com.ADSA.bsOnAns;

import java.util.spi.AbstractResourceBundleProvider;

public class nthRoot {
    public static void main(String[] args) {
        System.out.println(ans(3,27));
    }

    //return 1 if == n
    //return 0 if < n
    //return 2 if > n
    private static int func(int mid, int m , int n){
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans*mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    public static int ans(int n, int m){
        int s = 1, e = m;
        while(s<=e){
            int mid = s + (e-s)/2;
            int midN = func(mid,m,n);
            if(midN==1) return mid;
            if(midN == 2) {
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return -1;
    }
}
