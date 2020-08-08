package com.zc.hashtable;

import java.util.*;

/**
 * 描述:
 *给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 *     输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 *     我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 *     如果给定的数组已经排好序呢？你将如何优化你的算法？
 *     如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *     如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 * @Date: 8/8/20 4:47 下午
 **/
public class Intersect350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        return firstSolution(nums1, nums2);
    }

    /**
     * 优化后
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] better(int[] nums1, int[] nums2) {
        //<数字+频率>
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                result.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }

        int [] resultArr = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            resultArr[index++] = integer;
        }
        return resultArr;
    }
    private int[] firstSolution(int[] nums1, int[] nums2) {
        //<数字+频率>
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])){
                int key = nums2[i];
                result.add(key);
                if(map.get(key)>1){
                    map.put(key,map.get(key)-1);
                }else {
                    map.remove(key);
                }
            }
        }

        int [] resultArr = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            resultArr[index++] = integer;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] nums1  = new  int[]{1,2,2,1};
        int[] nums2  = new  int[]{2,2};
        System.out.println(Arrays.toString(new Intersect350().intersect(nums1, nums2)));
    }
}
