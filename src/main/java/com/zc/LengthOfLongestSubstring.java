package com.zc;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: zhangchao22
 * @Date: 2020/3/27 10:58
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 **/




public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        List<String> lis = Arrays.asList(s.split(""));
        for (String li : lis) {



        }

        return 1;

    }

    public static void main(String[] args) {
        String s = "hhjajayyiqww";
        lengthOfLongestSubstring(s);
    }
}
