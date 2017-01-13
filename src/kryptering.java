import java.io.*;
import java.util.*;

public class kryptering {

    public static void main(String[] args) throws IOException {


        String fil = "minfil.txt";

        FileReader fr = new FileReader(fil);
        BufferedReader infil = new BufferedReader(fr);

        String rad = infil.readLine();
        System.out.println("Okrypterat = " + rad);
        infil.close();

        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvxyz";
        for (int i = 0; i < rad.length(); i++) {
            //System.out.print(alphabet.charAt(r.nextInt(alphabet.length())));
            sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        String result = sb.toString();
        System.out.println("nyckel = " + result);

        File newTextFile = new File("nyckel.txt");
        FileWriter fw = new FileWriter(newTextFile);
        fw.write(result);
        fw.close();

        String crypt = "";
        for (int i = 1; i < rad.length(); i++) {
            char xorchar = (char) (rad.charAt(i) ^ result.charAt(i));
            crypt += xorchar;
        }
        System.out.println("krypterad text = " + crypt);

        String decrypt = "";
        for (int i = 0; i < crypt.length(); i++) {
            char decrypted = (char) (crypt.charAt(i) ^ result.charAt(i));
            decrypt += decrypted;
        }
        System.out.println("dekrypterad text = " + decrypt);

    }

}