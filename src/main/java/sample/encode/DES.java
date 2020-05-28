package sample.encode;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
public class DES {


    public static String encrypted(String original)throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        String SECRET_KEY = "12345678";
        SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(original.getBytes());
        String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
        return encrypted;
    }

    public static String decrypted(String byteEncrypted)throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        String SECRET_KEY = "12345678";
        SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] byteDecrypted = cipher.doFinal(Base64.getDecoder().decode(byteEncrypted));
        String decrypted = new String(byteDecrypted);
        return decrypted;
    }
}
