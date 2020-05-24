package com.zc.array;

/**
 * @描述:
 * @author: zhangchao
 * @date: 5/24/20 12:53 下午
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 *
 *
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 *
 **/
public class MoveZeroes_283 {

    /**
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //j为索引之前的元素(含)都不等于0   {0, 1, 0, 3, 12} ->{ 1 , 3, 12, 0, 0} -> j=3
        int j =0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                //只要不等于0,则需要交换位置
                nums[j++]=nums[i];
            }
        }

        while (j<nums.length){
            nums[j++]=0;
        }

    }
    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new MoveZeroes_283()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
