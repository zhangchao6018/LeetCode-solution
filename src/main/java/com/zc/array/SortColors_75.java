package com.zc.array;

/**
 * @描述:  todo 88,215
 * @author: zhangchao
 * @date: 5/24/20 7:07 下午
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 **/
public class SortColors_75 {

    public void sortColors(int[] nums) {
        //方案1
//        solution1(nums);
        //方案2 ->
        solution2(nums);

    }
    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * 仅遍历一次
     * @param nums
     */

    private void solution2(int[] nums) {
        //元素0的end索引(含)
        int zeroIdx = -1;
        //元素2的begin索引(含)
        int twoIdx = nums.length;
        //i的右边界
        for (int i = 0; i < twoIdx;) {
            if (nums[i] == 0){
                zeroIdx++;
                swap(nums,zeroIdx,i);
                i++;
            }else if (nums[i] == 2){
                twoIdx--;
                swap(nums,twoIdx,i);
            }else {
                //这种情况不需要交换位置
                i++;
            }
        }
    }

    /**
     * 交换指定数组两个索引之间的元素
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums
     */
    private void solution1(int[] nums) {
        //用索引对应值分别表示三种数值的存在次数
        int [] group = {0,0,0};
        for (int i = 0; i < nums.length; i++) {
            group[nums[i]]+=1;
        }
        //排序
        int index = 0;

        for (int i = 0; i < group[0]; i++) {
            nums[index++]=0;
        }
        for (int i = 0; i < group[1]; i++) {
            nums[index++]=1;
        }
        for (int i = 0; i < group[2]; i++) {
            nums[index++]=2;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        new SortColors_75().sortColors(nums);
        printArr(nums);
    }


    public static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }
}
