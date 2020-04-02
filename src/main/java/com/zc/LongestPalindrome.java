package com.zc;

/**
 * @Description:
 * @Author: zhangchao22
 * @Date: 2020/4/2 16:42
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 **/
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (s.length()<2){
            return s;
        }

        int x = s.length() % 2;


        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];
            if ((chars[i-1] == chars[i+1])) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
