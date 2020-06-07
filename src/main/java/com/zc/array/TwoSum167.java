package com.zc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * todo 第125,344,345,11题
 * 描述:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zhangchao
 * @Date: 6/7/20 4:50 下午
 **/
public class TwoSum167 {
    public int[] twoSum(int[] numbers, int target) {
        //1.暴力法-->超时
        //return m1(numbers, target);

        //2.思路 map-> key:当前遍历值的目标对象 value:索引
        //return m2(numbers, target);

        //3. 对撞指针法 根据numbers[i]+numbers[j] 跟target比较 小于->i++   大于-> j--  直到等于
        //return m3(numbers, target);

        //4. 二分搜索法(递归)
//        return m4(numbers, target);

        //5. 二分搜索法(非递归)
        return m5(numbers, target);
    }

    private int[] m5(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int index = binarySearch(numbers.length, target - numbers[i], numbers);
            if (index!=-1){
                return new int[]{i+1,index+1};
            }
        }
        return null;
    }

    private int[] m4(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int targetIndex = binarySearch(numbers[i], target, i + 1, numbers.length - 1, numbers);
            if (targetIndex!=-1){
                return new int[]{i+1,targetIndex+1};
            }
        }
        return null;
    }

    /**
     *
     * @param len 数组长度
     * @param target 目标值
     * @param numbers 数组
     * @return
     */
    private int binarySearch(int len , int target , int[] numbers) {
        int l =0;
        int r =len;
        int mid = (l+r)/2;
        while (r>l){
            if (numbers[mid]==target){
                return mid;
            }else if (numbers[mid]>target){
                mid = (l+mid)/2;
            }else {
                mid = (r+mid)/2;
            }
        }
        return -1;
    }

    /**
     *
     * @param source     当前元素的值
     * @param target     目标值
     * @param beginIdx   二分搜索起始索引
     * @param endIdx     二分搜索结束索引
     * @param numbers    源数组
     * @return
     */
    private int binarySearch(int source,int target,int beginIdx ,int endIdx ,int[] numbers) {
        if (beginIdx>endIdx){
            return -1;
        }
        int midIdx = (beginIdx+endIdx)/2;
        if (beginIdx==endIdx){
            System.out.println((source + numbers[beginIdx]));
            return (source + numbers[beginIdx]) == target?beginIdx:-1;
        }
        if (beginIdx+1==endIdx){

            return binarySearch(source,target,beginIdx,beginIdx,numbers)==-1?binarySearch(source,target,endIdx,endIdx,numbers):binarySearch(source,target,beginIdx,beginIdx,numbers);
        }
        if (source + numbers[midIdx] == target)
        return midIdx;
        else if ((source + numbers[midIdx]) > target) {
            return binarySearch(source,target,beginIdx,midIdx,numbers);
        }else {
            return binarySearch(source,target,midIdx,endIdx,numbers);
        }
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param numbers
     * @param target
     * @return
     */
    private int[] m3(int[] numbers, int target) {
        int i =0;
        int j =numbers.length-1;
        for (int x=i;x<j;){
            if (numbers[x]+numbers[j] == target){
                return new int[]{x+1,j+1};
            }
            if (numbers[x]+numbers[j] > target){
                j--;
            }else {
                x++;
            }
        }
        return null;
    }

    private int[] m2(int[] numbers, int target) {
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (container.containsKey(numbers[i]))
                return new int[]{container.get(numbers[i])+1,i+1};
            container.put(target-numbers[i],i);
        }
        return null;
    }

    private int[] m1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i!=j && target == numbers[i]+numbers[j]){
                    return i<=j?new int[]{i+1,j+1}:new int[]{j+1,i+1};
                }

            }
        }
        return null;
    }

    public static void main(String[] args) {
       // int[] arr = new int[]{2, 7, 11, 15};
//        int[] arr = new int[]{2,7,11,15};
//        int[] ints = new TwoSum167().twoSum(arr, 9);
        int[] arr = new int[]{2,7,11,15};
        int[] ints = new TwoSum167().twoSum(arr, 9);
        System.out.println(ints);
    }
}