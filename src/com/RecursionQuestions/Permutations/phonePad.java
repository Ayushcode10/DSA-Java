package com.RecursionQuestions.Permutations;

import com.OOPS.AccessControls.A;

import java.util.ArrayList;

public class phonePad {
    public static void main(String[] args) {
        System.out.println(padret("","12"));
    }
    public static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+", ");
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit-1)*3; i <digit*3 ; i++) {
            char ch = (char)('a' + i);
            pad(p+ch,up.substring(1));
        }
    }

    public static ArrayList<String> padret(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2->2
        ArrayList<String> list = new ArrayList<>();
        for (int i = (digit-1)*3; i <(digit*3); i++) {
            char ch = (char)('a' + i);
            list.addAll(padret(p+ ch, up.substring(1)));
        }
        return list;
    }
}
