/**
 * Project:sop-base-service-lib
 */

package com.yun.common.utils.encryption;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Base64;

/**
 * @author nathan
 */
public class TestAES extends TestCase {

    @Test
    public void testEncrypt() {
        String value = "hello world @!###$";
        String key = "x+fPbW0hI3geQfEPupkyGNuhM0iXiLZMUvePBwSi3fc=";
        String encrypted = AES.encrypt(key, value);
        System.out.println(encrypted);

        String decrypt = AES.decrypt(key, encrypted);
        System.out.println(decrypt);
        assertEquals(value, decrypt);
    }

    public static void main(String[] args) throws Exception {
        String key = "x+fPbW0hI3geQfEPupkyGNuhM0iXiLZMUvePBwSi3fc=";
        // String initVector = "iCDJ98Y0W2DL5SexCnLibQ==";
        // String ivForGetIV = "WqJXvZupmfpQMB2In+vY6Q==";

        // int length = Base64.getDecoder().decode(initVector).length;
        // System.out.println("iv length:" + length);
        String SP = "|";

        String appName = "testios";
        String appVer = "1.0";
        String phoneName = "iphone";
        String phoneVer = "7";
        String phoneSerno = "1111";
        String phoneOs = "IOS";
        String phoneOsVer = "12";
        String imei = "imei";
        String iccid = "";
        String imsi = "";
        String sonicCode = "3282409089";
        String langitude = "24.5678";
        String latitude = "26.1234";
        String accuracy = "100";
        // String reqTime = "1583494741135";

        // String value = appName + SP + reqTime;
        // String encrypted = AESEncryptor.encrypt(key, ivForGetIV, value);
        // System.out.println(encrypted);

        String value = appName + SP + appVer + SP + phoneName + SP + phoneVer + SP + phoneSerno + SP
                + phoneOs + SP + phoneOsVer + SP + imei + SP + iccid + SP + imsi + SP + sonicCode
                + SP + latitude + SP + langitude + SP + accuracy;
        System.out.println("source:" + value);
        String encrypted = AES.encrypt(key, value);
        System.out.println(encrypted);

        encrypted =
                "4d+wk31RzYJ/X8CkFnhc/SRTEa/81nyQnpCVbb5pjkjoS8dG9OjhHvl1NsmivC5vdOEQXq77omkQ3smwm+NEMGcU6ztk/ktKS5GE6FMtPZYctJd8nGmDIMRXO4LlgEus";
        testDecrypt(key, encrypted);

        String s = "{\"errCode\": \"APPID_NOT_EXISTS\"，\"errMsg\": \"app id不存在\"}";
        String encodeToString = Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
        System.out.println(encodeToString);

        s = "{\"content\": \"http://gw.soundbus.cn/s?__sd=1234\"，\"type\": \"URL\"}";
        encodeToString = Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
        System.out.println(encodeToString);

        s = "{\"errCode\": \"TIMEOUT\"，\"errMsg\": \"访问超时\"}";
        encodeToString = Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
        System.out.println(encodeToString);

    }

    private static void testDecrypt(String key, String encrypted) {
        String decrypt = AES.decrypt(key, encrypted);
        System.out.println(decrypt);
        System.out.println(decrypt.split("\\|", 1).length);
        System.out.println(decrypt.split("\\|", 0).length);
        System.out.println(decrypt.split("\\|", -1).length);
    }
}
