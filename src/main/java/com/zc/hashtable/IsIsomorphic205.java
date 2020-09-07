package com.zc.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * @Author: zhangchao
 * @Date: 8/9/20 9:34 上午
 **/
public class IsIsomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        //<s元素,t元素>
        Map<String,String> map = new HashMap();
        String[] sSplit = s.split("");
        String[] tSplit = t.split("");
        for (int i = 0; i < sSplit.length; i++) {
            if (!map.containsKey(sSplit[i])){
                if (map.containsValue(tSplit[i])){
                    //value被使用过
                    return false;
                }
                map.put(sSplit[i],tSplit[i]);

            }else {
                //包含key
                if (!map.get(sSplit[i]).equals(tSplit[i])){
                    //不一致
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(new IsIsomorphic205().isIsomorphic(s, t));

    }
}
