package sample.encode;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class StreamCipher {

    private static int ctLength;
    private static byte[] cipherText;

    public static String encrypt(String str,String key) throws Exception {
        byte[] input = str.getBytes();
        byte[] keyBytes = key.getBytes();
        SecretKeySpec key1 = new SecretKeySpec(keyBytes, "ARC4");
        Cipher cipher = Cipher.getInstance("ARC4", "BC");
        cipherText = new byte[input.length];
        cipher.init(Cipher.ENCRYPT_MODE,key1);
        ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        return new String(cipherText);
    }

    public static String decrypt(String str,String key)throws Exception {
        byte[] input = str.getBytes();
        byte[] keyBytes = key.getBytes();
        SecretKeySpec key1 = new SecretKeySpec(keyBytes, "ARC4");
        Cipher cipher = Cipher.getInstance("ARC4", "BC");
        cipher.init(Cipher.DECRYPT_MODE, key1);

        byte[] plainText = new byte[ctLength];
        int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);
        ptLength += cipher.doFinal(plainText, ptLength);
        return new String(plainText);

    }
}
