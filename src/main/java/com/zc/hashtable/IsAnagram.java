package com.zc.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 * @Date: 8/8/20 8:01 下午
 **/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        return s2(s, t);
    }

    /**
     * 用char[]解决
     *
     * @param s
     * @param t
     * @return
     */
    private boolean s2(String s, String t) {
        char[] s1=new char[26];
        char[] t1=new char[26];
        for(char c:s.toCharArray()){
            s1[c-'a']++;
        }
        for(char c:t.toCharArray()){
            t1[c-'a']++;
        }
        return Arrays.equals(s1,t1);
    }

    /**
     * 用map工具类解决
     * @param s
     * @param t
     * @return
     */
    private boolean s1(String s, String t) {
        Map<String , Integer> record = new HashMap();
        String[] sSplit = s.split("");
        String[] tSplit = t.split("");
        for (String s1 : sSplit) {
            if (record.get(s1)!=null && record.get(s1)>0){
                record.put(s1,record.get(s1)+1);
            }else {
                record.put(s1,1);
            }
        }
        for (String s1 : tSplit) {
            if (record.get(s1) !=null && record.get(s1)>0){
                record.put(s1,record.get(s1)-1);
            }else {
                return false;
            }
        }
        for (String key : record.keySet()) {
            if (record.get(key)>0){
                return false;
            }
        }
        //满足至此才为true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
    }
}
