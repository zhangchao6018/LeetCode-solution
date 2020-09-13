package com.zc.hashtable;

import java.util.TreeSet;

/**
 * 描述:
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zhangchao
 **/
public class ContainsNearbyAlmostDuplicate220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //滑动窗口
        int l=0;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling(((long)nums[i]-(long)t)) != null && set.ceiling(((long)nums[i]-(long)t)) <= (long)nums[i] + (long)t){
                return true;
            }
            set.add((long)nums[i]);

            if(set.size() == k + 1)
                set.remove((long)nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
//        int k = 3;
//        int[] nums = new int[]{1,2,3,1,2,3};
//        int k = 2;
        int[] nums = new int[]{1,100,4};
        int k = 2;
        int t = 2;
        System.out.println(new ContainsNearbyAlmostDuplicate220().containsNearbyAlmostDuplicate(nums, k,t));
    }
}
