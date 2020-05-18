package sample.encode;

public class Ceasar {
    public String MaHoa(String P,int k){
        String C = "";
        P = P.toUpperCase();//Chuyển thành chuổi in hoa
        for(int i = 0;i<P.length();i++)
            C += (char) ('A' + (P.charAt(i) - 'A' + k) % 26);
        return C;
    }

    public String GiaiMa(String C, int k){
        String kq="";
        for(int i = 0;i<C.length();i++)
            kq += (char) ('A' + (C.charAt(i) - 'A' + (26-k)) % 26);
        return kq;

    }
}
