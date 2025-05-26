package com.RecursionQuestions.Permutations;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(perCount("",s));
    }
    public static void permute(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+", ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <=p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permute(second+ch+first,up.substring(1));
        }
    }
    public static ArrayList<String> permuteList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        //local to this call
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i <=p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            res.addAll(permuteList(second+ch+first,up.substring(1)));
        }
        return res;
    }
    public static int perCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        char c = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count += perCount(f+c+s,up.substring(1));
        }
        return count;
    }

}
