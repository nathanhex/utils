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
        assertEquals(value, decrypt);
    }
}
