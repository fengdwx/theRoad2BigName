package com.cyyy.sort;

import cn.hutool.core.util.ArrayUtil;
import com.cyyy.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

// 归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] random = utils.random(501,2000);
        int[] cloned = ArrayUtil.clone(random);
        System.out.println(Arrays.toString(random));

        Arrays.sort(random);
        System.out.println(Arrays.toString(random));
        mergeSort(cloned);
        System.out.println("------");
        System.out.println(Arrays.toString(cloned));
        boolean flag = true;
        for (int i = 0; i < cloned.length; i++) {
            if (cloned[i] != random[i]){
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    // 思路就是局部有序，然后合并两个有序的集合。重点是 merge 的操作
    public static void recursionMergeSort(int[] nums,int start,int end){
        if (end == start) return;
        int middle = (start + end) / 2;
        recursionMergeSort(nums,start,middle); // 左边
        recursionMergeSort(nums,middle+1,end); // 右边
        merge(nums,start,end,middle);
    }
    // 非递归的实现
    // 思路就是先小段内有序，然后合并后在将小段的范围扩大，相当于递归展开。
    public static void mergeSort(int[] nums){
        if (nums == null || nums.length < 2) return;
        int step = 1;
        // 步长递增
        while (step < nums.length){
            int L = 0; // 左侧起点
            int R = L + step; // 右侧起点
            while (R < nums.length){
                int middle = R -1; // 中间位置
                int end = Math.min(nums.length-1,R+step-1); // 结束位置
                merge(nums,L,end,middle);
                L = R +step;
                R = L + step;
            }
            // 防止溢出
            if (step > nums.length / 2) break;
            step = step * 2;
        }
    }
    public static void merge(int[] nums,int start, int end, int middle){
        int[] tmp = new int[end-start + 1];
        int lStart = start;
        int rStart = middle + 1;
        int tmpIndex = 0;
        // 从左右两边出发，比较那边比较小就前进。
        while (lStart <= middle && rStart <= end){
            if (nums[lStart] > nums[rStart]){
                tmp[tmpIndex++] = nums[rStart++];
            }else {
                tmp[tmpIndex++] = nums[lStart++];
            }
        }
        while (lStart <= middle){
            tmp[tmpIndex++] = nums[lStart++];
        }
        while (rStart <= end){
            tmp[tmpIndex++] = nums[rStart++];
        }
        for (int i : tmp) {
            nums[start++] = i;
        }
    }
}
