package com.zc.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class ContainsNearbyDuplicate219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0){
            return false;
        }
        int l = 0;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                System.out.println(l);
                System.out.println(i);

                return true;
            }
            //绝对值大于k
            if (i-l>=k){
                //删除滑动窗口最左元素
                set.remove(nums[i-k]);
                l++;
            }
            set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
//        int k = 3;
//        int[] nums = new int[]{1,2,3,1,2,3};
//        int k = 2;
        int[] nums = new int[]{1,2,1};
        int k = 0;
        System.out.println(new ContainsNearbyDuplicate219().containsNearbyDuplicate(nums, k));

    }
}
