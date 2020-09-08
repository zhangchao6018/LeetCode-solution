package com.zc.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述:
 *给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。   
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 * @Date: 8/9/20 12:09 上午
 **/
public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        return s3(pattern, str);
    }


    private boolean s3(String pattern, String str) {
        String[] sSplit = str.split(" ");
        if (pattern.length()!=sSplit.length)
            return false;

        Map map = new HashMap<>();
        for (Integer i = 0; i < sSplit.length; i++) {
            //HashMap.put 返回old value
            if (map.put(sSplit[i],i)!=map.put(pattern.charAt(i),i)){
                return false;
            }
        }

        return true;
    }

    private boolean s2(String pattern, String str) {
        //<pattern的元素,str的元素>
        Map<String,String> map = new HashMap();
        String[] pSplit = pattern.split("");
        String[] sSplit = str.split(" ");
        if (pattern.length()!=sSplit.length)
            return false;

        for (int i = 0; i < pSplit.length; i++) {
            //不存在,保存
            if (!map.containsKey(pSplit[i])) {
                //如果一个key没出现过,但是对应value之前被用过->不满足条件
                //        String pattern= "abba";
                //        String str= "dog dog dog dog";
                if (map.containsValue(sSplit[i])){
                    return false;
                }
                map.put(pSplit[i], sSplit[i]);
            }else {
                //存在   同一个key,value必须相等才满足
                if (!map.get(pSplit[i]).equals(sSplit[i])){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean s1(String pattern, String str) {
        //<pattern的元素,str的元素>
        Map<String,String> map = new HashMap();
        String[] pSplit = pattern.split("");
        String[] sSplit = str.split(" ");
        //题目出的有问题...
        if(pattern.equals("")){
            return sSplit.length==0;
        }
        if (pSplit.length!=sSplit.length)
            return false;

        for (int i = 0; i < pSplit.length; i++) {
            //不存在,保存
            if (!map.containsKey(pSplit[i])) {
                map.put(pSplit[i], sSplit[i]);
            }else {
                //存在   同一个key,value必须相等才满足
                if (!map.get(pSplit[i]).equals(sSplit[i])){
                    return false;
                }
            }
        }
        Set keySet = new HashSet();
        Set valueSet = new HashSet();
        for (String key : map.keySet()) {
            keySet.add(key);
            valueSet.add(map.get(key));
        }
        return keySet.size()==valueSet.size();
    }

    public static void main(String[] args) {

        Object a = "a";
        Object b = 'a';
        System.out.println(a==b);
//        String pattern= "abba";
//        String str= "dog cat cat dog";
        //"abba"
        //"dog dog dog dog"
        String pattern= "abba";
        String str= "dog dog dog dog";
//        String pattern= "";
//        String str= "beef";
        System.out.println(new WordPattern290().wordPattern(pattern, str));
    }


}
