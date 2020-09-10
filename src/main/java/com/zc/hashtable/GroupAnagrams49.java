package com.zc.hashtable;

import java.util.*;

/**
 * 描述:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return f4(strs);
    }
    private List<List<String>> f4(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                List<String> list = new ArrayList(){};
                list.add(strs[i]);
                map.put(key,list);
            }

        }
        return new ArrayList<>( map.values());
    }
    private List<List<String>> f3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] table = new int[26];
            for (int i = 0; i < str.length(); i++) {
                table[str.charAt(i) - 'a']++;
            }
            StringBuffer keySb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                keySb.append(table[i] + "#");
            }
            String key = keySb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());

    }

    public List<List<String>> f2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<List<String>>(map.values());

    }
    private List<List<String>> f1(String[] strs) {
        boolean[] used = new boolean[strs.length];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> result = new ArrayList<>();
            if (used[i]){
                continue;
            }
            used[i] = true;
            result.add(strs[i]);
            for (int j = 0; j < strs.length; j++) {
                if (!used[j]){
                    if (equals(strs[i],strs[j])){
                        result.add(strs[j]);
                        used[j] =true;
                    }
                }
            }
            res.add(result);
        }
        return res;
    }

    private boolean equals(String string1, String string2) {
        Map<Character, Integer> hash = new HashMap<>();
        //记录第一个字符串每个字符出现的次数，进行累加
        for (int i = 0; i < string1.length(); i++) {
            if (hash.containsKey(string1.charAt(i))) {
                hash.put(string1.charAt(i), hash.get(string1.charAt(i)) + 1);
            } else {
                hash.put(string1.charAt(i), 1);
            }
        }
        //记录第一个字符串每个字符出现的次数，将之前的每次减 1
        for (int i = 0; i < string2.length(); i++) {
            if (hash.containsKey(string2.charAt(i))) {
                hash.put(string2.charAt(i), hash.get(string2.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        //判断每个字符的次数是不是 0 ，不是的话直接返回 false
        Set<Character> set = hash.keySet();
        for (char c : set) {
            if (hash.get(c) != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams49().groupAnagrams(arr);
        System.out.println(lists);
    }
}