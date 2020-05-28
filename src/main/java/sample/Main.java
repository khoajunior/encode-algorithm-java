package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.encode.*;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
       // launch(args);
        System.out.println("thuật toán Ceasar ");
        String message = "PhamMinhKhoa";
        System.out.println("chuỗi là " +message);
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println(CaesarCipher.encrypt(message, 3));
        System.out.println(CaesarCipher.decrypt(CaesarCipher.encrypt(message, 3), 3));


        System.out.println("----------------------------------------------------");
        String s = "PhamMinhKhoa";
        System.out.println("chuổi = Phạm Minh Khoa");
        System.out.println("thuật toán Ceasar mod");
        System.out.println("khóa = " + 3);
        Ceasar ce = new Ceasar();
        System.out.println("Chuổi cần mã hóa: "+ce.MaHoa("PhamMinhKhoa",3));
        System.out.println("Chuổi giải mã: "+ce.GiaiMa(ce.MaHoa("PhamMinhKhoa",3),3));

        System.out.println("----------------------------------------------------");
        System.out.println("thuật toán monoaphabetic");
        System.out.println("chuỗi sẽ mã hóa = phamminhkhoa");
        Monoaphabetic monoaphabetic  = new Monoaphabetic();
        System.out.println(monoaphabetic.doEncryption("phamminhkhoa"));
        System.out.println(monoaphabetic.doDecryption(monoaphabetic.doEncryption("phamminhkhoa")));

        System.out.println("----------------------------------------------------");
        System.out.println("thuật toán VigenèreCipher");
        String str = "PHAMMINHKHOA";
        String keyword = "ABC";
        System.out.println("chuỗi cần mã hóa"+str);
        System.out.println("chuỗi khóa"+ keyword);
        VigenèreCipher vigenèreCipher = new VigenèreCipher();
        String key = vigenèreCipher.generateKey(str,keyword);
        String cipher_text= vigenèreCipher.cipherText(str,key);
        System.out.println(cipher_text);
        System.out.println(vigenèreCipher.originalText(cipher_text,key));

        System.out.println("----------------------------------------------------");
        System.out.println("thuật toán PlayFair");
        Playfair playfair = new Playfair();
        String keyword1= "smythework";
        playfair.setKey(keyword1);
        playfair.KeyGen();
        System.out.println(playfair.encryptMessage("dhkh"));


        System.out.println("----------------------------------------------------");
        System.out.println("thuật toán RailFence");
        System.out.println("chuỗi cần mã hóa="+str);
        RailFence railFence = new RailFence();
        String railciphertext = railFence.Encryption(str,3);
        System.out.println("chuỗi mã hóa "+railciphertext);
        System.out.println("chuỗi giải mã"+ railFence.Decryption(railciphertext,3));


        System.out.println("-----------------------------------------------------");
        System.out.println("thuật toám Steam Cipher");
        stremcipher();
        System.out.println(StreamCipher.encrypt("phamminhkhoa","input123"));
        System.out.println(StreamCipher.decrypt(StreamCipher.encrypt("phamminhkhoa","input123"),"input123"));


        System.out.println("-----------------------------------------------------");
        System.out.println("thuật toám Block Cipher");
        final String secretKey = "abc123";

        String originalString = "phamminhkhoa";
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println("Từ muốn mã hóa "+originalString);
        System.out.println("từ đã mã hóa "+encryptedString);
        System.out.println("từ gốc "+decryptedString);

        System.out.println("-----------------------------------------------------");
        System.out.println("thuật toám DES");
        System.out.println("từ muốn mã hóa "+ originalString);
        System.out.println(DES.encrypted(originalString));
        System.out.println(DES.decrypted(DES.encrypted(originalString)));



        System.out.println("-----------------------------------------------------");
        System.out.println("thuật toám triple DES");
        System.out.println("từ muốn mã hóa "+ originalString);
        TripleDES tripleDES = new TripleDES("abc123");
        System.out.println(tripleDES.harden(originalString));
        System.out.println(tripleDES.soften(tripleDES.harden(originalString)));
    }




    private static void stremcipher() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        byte[] input = "phamminhkhoa".getBytes();
        byte[] keyBytes = "input123".getBytes();

        SecretKeySpec key = new SecretKeySpec(keyBytes, "ARC4");

        Cipher cipher = Cipher.getInstance("ARC4", "BC");

        byte[] cipherText = new byte[input.length];

        cipher.init(Cipher.ENCRYPT_MODE, key);

        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);

        ctLength += cipher.doFinal(cipherText, ctLength);

        System.out.println("cipher text: " + new String(cipherText));
//
//        for(int i = 0 ;i< cipherText.length;i++){
//            System.out.println(cipherText[i]);
//        }

        byte[] plainText = new byte[ctLength];

        cipher.init(Cipher.DECRYPT_MODE, key);

        int ptLength = cipher.update(cipherText, 0, ctLength, plainText, 0);

        ptLength += cipher.doFinal(plainText, ptLength);

        System.out.println("plain text : " + new String(plainText));
    }
}
