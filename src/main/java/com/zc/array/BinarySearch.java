package com.zc.array;

/**
 * @描述:
 * @author: zhangchao
 * @date: 5/24/20 11:14 上午
 **/
public class BinarySearch {
    private BinarySearch(){}

    /**
     * 给定一个有序数组,该数组长度,以及目标元素,返回改目标元素在数组索引
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public static int binarySearch(Comparable[] arr, int n, Comparable target){
        //索引左边界
        int l =0;
        //索引右边界
        int r = n-1;
        while (l<=r){
            for (int i = l; i <= r; i--) {
                int mid = (l+r)/2;
                if (arr[mid].compareTo(target)==0)
                    return mid;
                if (arr[mid].compareTo(target)>0)
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int n = (int)Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < n ; i ++)
            if(i != binarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
