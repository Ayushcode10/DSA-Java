package com.RecursionQuestions;

import com.OOPS.AccessControls.A;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subDuplicate(arr));
    }

    public static int[] sort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int m = arr.length/2;
        int[] l = sort(Arrays.copyOfRange(arr,0,m));
        int[] r = sort(Arrays.copyOfRange(arr,m,arr.length));

        return merge(l,r);
    }

    private static int[] merge(int[] l, int[] r) {
        int[] mix = new int[l.length + r.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<l.length && j<r.length){

            if(l[i]<r[j]){
                mix[k] = l[i];
                i++;
            }
            else{
                mix[k] = r[j];
                j++;
            }
            k++;

        }
        while (i<l.length){
            mix[k] = l[i];
            i++;
            k++;
        }
        while (j<r.length){
            mix[k] = r[j];
            j++;
            k++;
        }
        return mix;
    }

    public static int[] s(int [] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] l = s(Arrays.copyOfRange(arr, 0, mid));
        int[] r = s(Arrays.copyOfRange(arr, mid, arr.length));

        return m(l,r);
    }

    private static int[] m(int[] l, int[] r) {
        int[] mix = new int[l.length + r.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<l.length && j<r.length){
            if(l[i]<r[j]){
                mix[k] = l[i];
                i++;
            }
            else {
                mix[k] = r[j];
                j++;
            }
            k++;
        }
        while (i<l.length){
            mix[k] = l[i];
            i++;
            k++;
        }while (j<r.length){
            mix[k] = r[j];
            j++;
            k++;
        }
        return mix;
    }

    public static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(p + ch,up.substring(1));
        subSeq(p,up.substring(1));

    }
    public static ArrayList<String> subSeq2(String p, String up,ArrayList<String> a){
//        ArrayList<String> a = new ArrayList<>();
        if(up.isEmpty()){
            a.add(p);
            return a;
        }
        char ch = up.charAt(0);
        subSeq2(p + ch,up.substring(1),a);
        subSeq2(p,up.substring(1),a);
        return a;
    }
    public static void ascii(String p, String up){
//        ArrayList<String> a = new ArrayList<>();
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        ascii(p + ch,up.substring(1));
        ascii(p,up.substring(1));
        ascii(p + (ch+0) ,up.substring(1));
    }

    public static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i : arr){
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internal  = new ArrayList<>(outer.get(j));
                internal.add(i);
                outer.add(internal);
            }
        }
        return outer;
    }

    public static List<List<Integer>> subsetRecursive(int[] arr){
        List<List<Integer>> res  = new ArrayList<>();
        generateSubsets(arr,0,new ArrayList<>(),res);
        return res;
    }
    private static void generateSubsets(int[] arr,int index,List<Integer> curr, List<List<Integer>> res){
        if(index == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        generateSubsets(arr,index+1,curr,res);
        curr.add(arr[index]);
        generateSubsets(arr,index+1,curr,res);
        curr.remove(curr.size()-1);
    }
    //subsets with duplicate elements

    public static List<List<Integer>> subDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        genDpli(arr,0,new ArrayList<>(), res);
        Set<List<Integer>> uniqueSubsets = new HashSet<>(res);
        return new ArrayList<>(uniqueSubsets);
//        Arrays.sort(arr);
//        List<List<Integer>> outer = new ArrayList<>();
//        outer.add(new ArrayList<>());
//        int start = 0, end = 0;
//        for(int i=0;i<arr.length;i++){
//            start = 0;
//            //if curr and prev element is same then s = e+1;
//            if(i>0 && arr[i] == arr[i-1]){
//                start = end+1;
//            }
//            int n = outer.size();
//            end = n-1;
//            for(int j=start;j<n;j++){
//                List<Integer> inner = new ArrayList<>(outer.get(j));
//                inner.add(arr[i]);
//                outer.add(inner);
//            }
//        }
//        return outer;
    }

    public static void genDpli(int[] arr, int i, List<Integer> curr,List<List<Integer>> res){
        if(i == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        genDpli(arr,i+1,curr,res);

            curr.add(arr[i]);
            genDpli(arr,i+1,curr,res);
            curr.remove(curr.size()-1);
    }
}