package com.yun.common.utils;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类，验证数据是否符合规范
 */
public abstract class RegexUtils {

    private RegexUtils() {
    }
    public static final  Pattern emailPattern =
            Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    /**
     * 判断输入的字符串是否符合Email格式.
     *
     * @param email 传入的字符串
     * @return 符合Email格式返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        return emailPattern.matcher(email).matches();
    }

    public static final  Pattern chinesePattern = Pattern.compile("[\u0391-\uFFE5]+$");
    /**
     * 判断输入的字符串是否为纯汉字
     *
     * @param value 传入的字符串
     */
    public static boolean isChinese(String value) {
        return chinesePattern.matcher(value).matches();
    }

    /**
     * 判断是否为浮点数，包括double和float
     *
     * @param value 传入的字符串
     */
    public static final Pattern doblePattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");

    public static boolean isDouble(String value) {
        return doblePattern.matcher(value).matches();
    }

    public static final  Pattern intPattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
    /**
     * 判断是否为整数
     *
     * @param value 传入的字符串
     */
    public static boolean isInteger(String value) {
        return intPattern.matcher(value).matches();
    }
}
