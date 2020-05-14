package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.encode.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        //launch(args);
        String s = "PhamMinhKhoa";
        System.out.println("chuổi = Phạm Minh Khoa");
        System.out.println("thuật toán Ceasar");
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





    }
}
