package com.zc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhangchao22
 * @Date: 2020/3/27 10:58
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 **/




public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    maxLength = Math.max(maxLength, j - leftIndex);
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }


    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        String trim = s.trim();
        if ("".equals(trim)) {
            return 1;
        }
        int result = 1;
        return getResult(s, result);
    }

    private static int getResult(String s, int result) {
        if ("".equals(s)){
            return result;
        }
        List<String> lis = Arrays.asList(s.split(""));
        Set set = new HashSet();
        for (int i = 0 ;  i< lis.size() ; i++) {
            String s1 = lis.get(i);
            if (!set.contains(s1)) {
                set.add(s1);
                result = result>set.size()?result:set.size();
            }else {
                //重复了->统计size
                int size = set.size();
                result = result>size?result:size;
                //清空set
                set.clear();
                set.add(s1);
                //重置入参s
            }
        }
        s = s.substring(1);
        return getResult(s,result);
    }

    public static void main(String[] args) {
//        String s = "hhjajayyiqww";
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
