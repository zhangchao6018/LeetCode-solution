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
    //todo 当传入""  错误 ->预期 1 结果:0
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        String trim = s.trim();
        if ("".equals(trim)) {
            return 1;
        }
        int result = 1;
        List<String> lis = Arrays.asList(s.split(""));
        Set set = new HashSet();
        for (int i = 0 ;  i< lis.size() ; i++) {
            String s1 = lis.get(i);
            if (!set.contains(s1)) {
                boolean add = set.add(s1);
            }else {
                //重复了->统计size
                int size = set.size();
                result = result>size?result:size;
                //清空set
                set.clear();
                set.add(s1);
            }
        }

        return result;

    }

    public static void main(String[] args) {
//        String s = "hhjajayyiqww";
        String s = "";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
