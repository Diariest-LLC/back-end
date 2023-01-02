package com.diariest.server.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UtilEncrypt {

    private static final SecretKeySpec secretKey = new SecretKeySpec("2650053489057341".getBytes(), "AES");

    public static String encrypt(String encryptInput) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(encryptInput.getBytes(StandardCharsets.UTF_8)));
        } catch(Exception ex) {
            return null;
        }
    }

    public static String decrypt(String decryptInput) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(decryptInput)));
        } catch(Exception ex) {
            return null;
        }
    }

}
