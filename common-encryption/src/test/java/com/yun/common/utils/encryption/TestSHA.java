/**
 * Project:sop-core-encryption
 */
package com.yun.common.utils.encryption;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author nathan
 */
public class TestSHA {

    @Test
    public void testHash() {
        String s = "1234567";
        String hash1 = SHA.getSha256().hash(s);
        String hash2 = SHA.getSha256().hash(s);
        String hash3 = SHA.getSha256().hash(s);

        System.out.println("hash1:" + hash1);
        Assert.assertEquals(hash1, hash2);
        Assert.assertEquals(hash1, hash3);
    }
}
