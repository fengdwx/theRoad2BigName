package com.cyyy.sort;

import cn.hutool.core.util.ArrayUtil;
import com.cyyy.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

// 归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] random = utils.random(800,10000);
        int[] cloned = ArrayUtil.clone(random);
        System.out.println(Arrays.toString(random));

        Arrays.sort(random);
        System.out.println(Arrays.toString(random));
        recursionMergeSort(cloned,0,cloned.length-1);
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
        }
    }
    public static void recursionMergeSort(int[] nums,int start,int end){
        int middle = (start + end) / 2;
        if (end - start >= 2){
            recursionMergeSort(nums,start,middle); // 左边
            recursionMergeSort(nums,middle+1,end); // 右边
        }
        merge(nums,start,end,middle);
    }
    public static void merge(int[] nums,int start, int end, int middle){
        int[] tmp = new int[end-start + 1];
        int lStart = start;
        int rStart = middle + 1;
        int tmpIndex = 0;
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
