package com.cyyy;

import cn.hutool.core.util.RandomUtil;

public class utils {
    public static int[] random(int size,int limit){
        assert size>=1;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = RandomUtil.randomInt(0,limit);
        }
        return result;
    }
}
