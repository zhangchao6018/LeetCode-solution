package com.zc.hashtable;

import java.util.*;

/**
 * 描述:
 *给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 说明：
 *
 *     输出结果中的每个元素一定是唯一的。
 *     我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 * @Date: 8/8/20 4:20 下午
 **/
public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> containner = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            containner.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (containner.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int [] result = new int[resultSet.size()];
        int index = 0;
        for (Integer i : resultSet) {
            result[index++]=i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1  = new  int[]{1,2,2,1};
        int[] nums2  = new  int[]{2,2};
        System.out.println(Arrays.toString(new Intersection349().intersection(nums1, nums2)));
    }
}
