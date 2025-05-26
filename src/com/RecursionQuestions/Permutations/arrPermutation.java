package com.RecursionQuestions.Permutations;


import com.OOPS.AccessControls.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 46
public class arrPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        swap(arr,arr[0],arr[1]);
        System.out.println(Arrays.toString(arr));
//        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),arr);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> temp, int[] arr){
        if(temp.size() == arr.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i<arr.length;i++){
            if(temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            helper(res,temp,arr);
            temp.remove(temp.size()-1); // backtrack
        }

    }
    private void helperSwap(int[] arr, int index, List<List<Integer>> res){

    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
