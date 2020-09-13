package com.zc.hashtable;

import java.util.*;

/**
 * 描述:
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @Author: zhangchao
 **/
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        return f2(nums);
    }

    private boolean f3(int[] nums) {
        //时间复杂度依赖于排序算法
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    private boolean f2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    private boolean f1(int[] nums) {
        //<value-count>
        Map<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)){
                return true;
            }else
                map.put(num,1);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
