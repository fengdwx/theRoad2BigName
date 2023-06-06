package com.cyyy;

public class SingleNumber {
    public static void main(String[] args) {

    }

    // 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static int singleNumber(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer = answer ^ num;
        }
        return answer;
    }

    // 260. 给你一个整数数组 nums，其中恰好有两个元素只出现奇数次，其余所有元素均出现偶数次。 找出那两个元素。你可以按 任意顺序 返回答案。
    // 通过第一次循环得到了 x ^ y
    // 然后通过找到最右侧位置bit 为 1
    // 通过这个位置将数据分为 2 类，然后x 和 y 必定分开(因为这个x^y的值是 1)
    // 并且每一类数据除了要找的答案之外的其他数据也都出现偶数次，
    // 通过对其中一类进行运算。找到其中一个答案，然后  y = x ^ y ^ x
    public static int[] singleNumber3(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int rightOne = xor & -xor;
        int answer1 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                answer1 = answer1 ^ num;
            }
        }
        int answer2 = answer1 ^ xor;
        return new int[]{answer1, answer2};
    }

    // 137. 一个数组中有一种数出现K次，其他数都出现了M次，已知 M > 1，K < M，找到出现了K次的数
    // 构建一个 32 长度的数组，每个位置表示出现 这个位置所有数在该 bit 位出现 1 的次数总和，那么 该和= M*N + K*X (假设需要找的数是 X)
    // 如果改数字是 M 的倍数，就说明要找的数在该位置是 0 反之就是 1
    public static int singleNumber2(int[] nums, int k, int m) {
        int answer = 0;
        int[] bitOneCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < bitOneCount.length; i++) {
                if ((num >> i & 1) == 1) {
                    bitOneCount[i]++;
                }
            }
        }
        for (int i = 0; i < bitOneCount.length; i++) {
            if (bitOneCount[i] % m != 0) {
                answer = (1 << i) ^ answer;
            }
        }
        return answer;
    }
}