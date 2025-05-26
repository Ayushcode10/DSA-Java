package com.RecursionQuestions.Subsets;

import com.OOPS.AccessControls.A;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subsetDuplicate(arr));

    }

    public static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>() ;

        outer.add(new ArrayList<>());

        for(int n : arr){
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(n);
                outer.add(internal);
            }
        }
        return outer;
    }

    public static List<List<Integer>> subsetDuplicate(int[] arr){
        //sort the arr to get the duplicates in consecutive manner
        Arrays.sort(arr);
        //create and initialize an outer list with an empty list
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0, end =0;//use a start and an end pointer
        // (determine where to start adding new subsets)
        for(int i=0;i<arr.length;i++){//iterate the arr
            start = 0;//set start = 0
            //if there are dupes then set start to end + 1(skip the dupes)
            if(i>0 && arr[i] == arr[i-1]){
                start = end + 1 ;
            }
            int n = outer.size();
            //set the end to the last index
            end = n-1;
            //iterate the outer list
            for (int j = start; j < n; j++) {
                //copy the subsets
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);//add the curr subsets in the inner list
                outer.add(inner);//add the subset in the outer list
            }
        }
        return outer;
    }
}
