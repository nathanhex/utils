/**
 * Project:sop-core-encryption
 */
package com.yun.common.utils.encryption;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author nathan
 */
public class TestRSA {

    @Test
    public void testRSA() {
        String[] keys = RSA.genRsa512PublicPrivateKeys();
        String publicKey = keys[0];
        String privateKey = keys[1];

        String value = "hello nathan 99";
        System.out.println("value:" + value);

        String privateKeyEncrypt = RSA.privateKeyEncrypt(privateKey, value);
        System.out.println("privateKeyEncrypt:" + privateKeyEncrypt);

        String publicKeyDecrypt = RSA.publicKeyDecrypt(publicKey, privateKeyEncrypt);
        Assert.assertEquals(value, publicKeyDecrypt);

        String publicKeyEncrypt = RSA.publicKeyEncrypt(publicKey, value);
        System.out.println("publicKeyEncrypt:" + publicKeyEncrypt);

        String privateKeyDecrypt = RSA.privateKeyDecrypt(privateKey, publicKeyEncrypt);
        Assert.assertEquals(value, privateKeyDecrypt);
    }

    @Test
    public void testDecodePem() {
        String pemEncoded = "-----BEGIN PUBLIC KEY-----\n" + "123412341234\n" + "abcdabcdabcd\n"
                + "-----END PUBLIC KEY-----";

        String key = RSA.decodePem(pemEncoded);
        Assert.assertEquals("123412341234abcdabcdabcd", key);
    }
}
