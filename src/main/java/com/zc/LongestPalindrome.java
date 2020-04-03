package com.zc;

/**
 * @Description:
 * @Author: zhangchao22
 * @Date: 2020/4/2 16:42
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 **/
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        int length = s.length();
        int beginTmp = 0;
        int endTmp = 0;
        for (int i = 0; i < length; i++) {
            int beginInx = i-1;
            int endInx = i+1;
            int beginInx1 = i;
            int endInx1 = i+1;
            //aba模式
            while (beginInx >=0 && length-endInx >= 1){
                if (chars[beginInx]!=chars[endInx])  break;
                //可比较
                if (endTmp-beginTmp<endInx-beginInx){
                    beginTmp = beginInx;
                    endTmp = endInx;
                }
                beginInx = beginInx-1;
                endInx = endInx+1;
            }
            //aabb模式
            while (beginInx1 >=0 && length-endInx1 >= 1){
                if (chars[beginInx1]!=chars[endInx1])  break;
                //可比较
                if (endTmp-beginTmp<endInx1-beginInx1){
                    beginTmp = beginInx1;
                    endTmp = endInx1;
                }
                beginInx1 = beginInx1-1;
                endInx1 = endInx1+1;
            }
        }

        return s.substring(beginTmp,endTmp+1);
    }

    public static void main(String[] args) {
//        longestPalindrome("fsssssssssssssssssssssssssssssssssssssssssss");
        System.out.println(longestPalindrome("fssssssssssssssssasssssssssssssssssssssssssss"));
        System.out.println();
    }
}
