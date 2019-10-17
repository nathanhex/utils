package com.yun.common.utils;

import java.math.BigInteger;
import java.util.Random;

/**
 * ID工具类
 */
public abstract class IdUtils {
    private IdUtils() {
    }

    public static String getUUID() {
        String idstr = java.util.UUID.randomUUID().toString().replace("-", "");
        return idstr.toUpperCase();
    }

    public static BigInteger getGUID() {
        return new BigInteger(128, new Random());
    }

    /**
     * 生成随机码
     *
     * @param length 长度
     * @return 随机码
     */
    public static int getRandomInteger(int length) {
        Double powD = Math.pow(10, length);
        Long pow = powD.longValue();
        Double r = Math.random() * pow;
        return r.intValue();
    }
}
