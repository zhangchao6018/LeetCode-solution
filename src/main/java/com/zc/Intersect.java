package com.zc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/19/20 5:03 下午
 *
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 **/
public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            Integer count = map.get(key);
            if (count!=null){
                map.put(key, ++count);
            }else {
                map.put(key, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (map.containsKey(key)){
                list.add(key);
                Integer count = map.get(key);
                count--;
                map.put(key,count);
                if (count==0){
                    map.remove(key);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++)
            res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1,2,1};
        int[] num2 = {2,2,2,1};
        int[] intersect = intersect(num1, num2);
        System.out.println(intersect);
    }
}
