import java.util.ArrayList;

/**
 * Created by zeynel on 01.06.17.
 */
public class App {

    final static int N = 8; // ANZAHL DER SPEICHERADRESSEN
    final static String[][] speicher = new String[N][2];

    final static ArrayList<Character> buchstabenListe = new ArrayList<>();
    final static ArrayList<Integer> zahlenListe = new ArrayList<>();
    final static Quersumme element = new Quersumme(buchstabenListe, zahlenListe);


    final static Speicher storage = new Speicher(speicher, N);


    public static void main(String [ ] args) {
        storage.save("Graz", "0316");
        storage.save("Dornbrin", "05572");

        storage.load("Graz");
        storage.load("Dornbrin");
        //storage.load("Graz");
    }

}

