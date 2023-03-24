package com.mslk.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Aes256Util {

    public static final String iv = "iv 키값";

    /* AES_128_CBC Key 생성 함수 */
    public static Key getAESKey()
    {
        Key keySpec = null;
        try {

            String key = "키 값";
            byte[] keyBytes = new byte[16];
            byte[] b;
            b = key.getBytes("UTF-8");

            int len = b.length;
            if (len > keyBytes.length)
            {
                len = keyBytes.length;
            }

            System.arraycopy(b, 0, keyBytes, 0, len);
            keySpec = new SecretKeySpec(keyBytes, "AES");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return keySpec;
    }

    // 암호화
    public static String encryptAES256(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException
    {
        Key keySpec = getAESKey();
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));

        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));

        return enStr;
    }

    //복호화
    public static String decryptAES256(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException
    {
        Key keySpec = getAESKey();
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));

        byte[] byteStr = Base64.decodeBase64(str.getBytes());

        return new String(c.doFinal(byteStr),"UTF-8");
    }
}
