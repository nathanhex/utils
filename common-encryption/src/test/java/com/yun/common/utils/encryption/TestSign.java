package com.yun.common.utils.encryption;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class TestSign
 *
 * @author nathan
 */
public class TestSign {

    @Test
    public void testSignature() {
        String[] keys = RSA.genRsa512PublicPrivateKeys();
        String publicKey = keys[0];
        String privateKey = keys[1];

        String data = "hello world";
        String signature = Sign.signature(privateKey, data);
        System.out.print("signature:" + signature);

        boolean pass = Sign.verify(publicKey, data, signature);
        Assert.assertTrue(pass);
    }
}
