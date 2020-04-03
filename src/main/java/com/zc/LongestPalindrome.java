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
    public static String longestPalindrome2(String s){
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        //装符合回文起止索引的容器
        int [] container = new int[2];
        for (int i = 0; i < chars.length; i++) {
            findMore(i,chars,container);
        }

        return s.substring(container[0],container[1]+1);
    }

    private static void findMore(int i, char[] chars, int[] container) {
        //根据索引值初始化
        int begin =i-1;
        int end =i+1;

        while (begin>=0 &&
                chars.length >= end+1 &&
                chars[begin] == chars[end]
        )
        {
            if (container[1]-container[0]<=end-begin){
                container[0] = begin;
                container[1] = end;
            }
            begin -- ;
            end ++;

        }


        if (container[0]==container[1]){
            container[0] = i;
            container[1] = i;
        }
    }

    public static void main(String[] args) {
//        longestPalindrome("fsssssssssssssssssssssssssssssssssssssssssss");
        //System.out.println(longestPalindrome("fssssssssssssssssasssssssssssssssssssssssssss"));
//        System.out.println(longestPalindrome2("fssssssssssssssssasssssssssssssssssssssssssss"));
        System.out.println(longestPalindrome2("aabb"));
        System.out.println();
    }
}
