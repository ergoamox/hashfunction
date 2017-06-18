import java.util.ArrayList;

/**
 * Created by zeynel on 01.06.17.
 */

public class Quersumme {
    ArrayList<Character> buchstabenListe;
    ArrayList<Integer> zahlenListe;

    public Quersumme(ArrayList<Character> buchstabenListe, ArrayList<Integer> list){
        this.buchstabenListe = buchstabenListe;
        this.zahlenListe = list;
    }

    int getQuersumme(String schlüssel){
        // Speichert "schlüssel" Wert in einzele Characters in buchstabenListe
        for(int i=0; i<schlüssel.length(); i++) {
            char b = (char) schlüssel.substring(i, i+1).charAt(0);
            buchstabenListe.add(b);
        }

        // Nimmt Character Elemente aus buchstabenListe und rechnet sie zu Zahlen um
        // Und speichert sie anschließend in list
        for(int i=0; i<buchstabenListe.size(); i++){
            char c = Character.toUpperCase(buchstabenListe.get(i));
            zahlenListe.add(i, (int) (c)-64);
        }

        // Aus zahlenListe werden die Zahlen nacheinander ausgelesen und zsm addiert
        int quersumme = 0;
        for (int i=0; i<zahlenListe.size(); i++){
            quersumme = quersumme+zahlenListe.get(i);
        }

        buchstabenListe.clear();
        zahlenListe.clear();

        return quersumme;
    }

}
