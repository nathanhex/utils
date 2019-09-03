package com.yun.common.utils.encryption;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Class TestEnc
 *
 * @author nathan
 */
public class TestEnc {

    @Test
    public void testEncoding() {
        int i = 15;
        String s = Integer.toString(i, 16);
        Assert.assertEquals("f", s);
        s = Integer.toString(i, 36);
        Assert.assertEquals("f", s);

        s = Integer.toString(62, 36);
        Assert.assertEquals("1q", s);

        int r = Integer.parseInt("f", 36);
        Assert.assertEquals(15, r);

        String a = Enc.compressHexTo62("f");
        Assert.assertEquals("f", a);
        a = Enc.compressHexTo62("ff");
        Assert.assertEquals("47", a);
        a = Enc.compressHexTo62("ffffffffffffffff");
        Assert.assertEquals("4GFfc34GFfc3", a);

        String b = Enc.compress36To62("1q");
        Assert.assertEquals("10", b);
        b = Enc.compress36To62("f");
        Assert.assertEquals("f", b);
        b = Enc.compress36To62("z");
        Assert.assertEquals("z", b);
        b = Enc.compress36To62("zzzzzzzz");
        Assert.assertEquals("NFmNFGT", b);
        b = Enc.compress36To62("zzzzzzzzzzzzzzzzz");
        Assert.assertEquals("NFmNFGTNFmNFGTz", b);

        String s1 = Enc.compress36To62(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(s1);
        System.out.println(s1.length());
    }
}
