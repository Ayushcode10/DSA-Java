package com.ADSA.bsOnAns;

public class sqrtx {
    public static void main(String[] args) {
        System.out.println(ans(144));
    }

    public static int ans(int n){
       int s = 1, e = n;
       while(s<=e){
           int m = s + (e-s)/2;
           if(m*m == n){
               return m;
           }
           if(m*m > n){
               e = m-1;
           }
           else{
               s = m+1;
           }
       }
       return -1;
    }

}
