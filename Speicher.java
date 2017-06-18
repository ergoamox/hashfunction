import java.util.ArrayList;

/**
 * Created by zeynel on 01.06.17.
 */
public class Speicher {
    int N=16; // Anzahl der Speicheradressen
    String[][] speicher = new String[N][2];

    // für Quersumme
    final static ArrayList<Character> buchstabenListe = new ArrayList<>();
    final static ArrayList<Integer> zahlenListe = new ArrayList<>();
    final static Quersumme element = new Quersumme(buchstabenListe, zahlenListe);
    public int speicheradresse;

    public Speicher(String[][] speicher, int speichergröße){
        this.speicher = speicher;
        this.N = speichergröße;
    }

    void action(){

    }

    void save(String schlüssel, String wert){
        boolean kollision = false; // Variabeln für Kollisionszustand deklariert
        int speicheradresse = element.getQuersumme(schlüssel)%(N-1);

        for(int i=speicheradresse;i<N;i++){
            if(speicher[i][0] == null){
                // falls die Speicherzelle leer ist
                System.out.println("In " + i + "te Speicherzelle gespeichert! Quersumme: " + speicheradresse);
                speicher[i][0] = schlüssel; // Speichere Schlüssel
                speicher[i][1] = wert;
                kollision=false; // Kollisionszustand zustand setzen
                i=N; // Schleifen abbrechen
            }else{
                if(speicher[i][0]==schlüssel){
                    // Kollision falls die Speicherzelle nicht leer ist
                    kollision = false;
                    i=N;
                }else {
                    // Kollision falls die Speicherzelle nicht leer && Schlüsselwerte nicht identisch
                    kollision = true;
                }

            }
        }

        if(kollision==true){
            for (int i=0;i<speicheradresse;i++){
                if(speicher[i][0] == null){
                    System.out.println("In " + i + "te Speicherzelle gespeichert! + Quersumme: " + speicheradresse);
                    speicher[i][0] = schlüssel;
                    speicher[i][1] = wert;
                    kollision=false;
                    i=speicheradresse; // Schleife abbrechen
                }else {
                    kollision=true;
                }
            }
        }
        if(kollision==true){
            System.out.println("Kollision konnte trotz Schutzmechanismus nicht verhindert werden!");
            System.out.println("Bitte erweitern Sie die Anzahl der Speicheradressen :)");
        }

    }

    void load(String schlüssel){
        int speicheradresse = element.getQuersumme(schlüssel)%(N-1);
        boolean kollision = false; // Variabeln für Kollisionszustand deklariert

        for(int i=speicheradresse;i<N;i++){
            if(speicher[i][0] == schlüssel){
                // falls Schlüsseln identisch
                System.out.println("Speicheradresse("+i+")-->Schlüssel("+ schlüssel +")-->Wert(" +speicher[i][1]+")"); // Auslesevorgang
                kollision=false; // Kollisionszustand setzen
                i=N; // Schleifen abbrechen
            }else{
                // Kollision falls die Speicherzelle nicht identisch oder leer ist
                kollision = true;
            }
        }
        if(kollision==true){
            for (int i=0;i<speicheradresse;i++){
                if(speicher[i][0] == schlüssel){
                    System.out.println("Speicheradresse("+i+")-->Schlüssel("+ schlüssel +")-->Wert(" +speicher[i][1]+")");
                    kollision = false;
                    i=speicheradresse; // Schleife abbrechen
                }else {
                    kollision=true;
                }
            }
        }
        if(kollision==true){ // Abbruchbedingung falls Speicher voll ist oder ungültiger Schlüssel
            System.out.println("\nERROR!: Beim Ladevorgang Schlüssel nicht gefunden oder Kollision konnte trotz Schutzmechanismus nicht verhindert werden!");
            System.out.println("Bitte erweitern Sie die Anzahl der Speicheradressen oder geben Sie einen gültigen Schlüssel ein...");
        }

    }
}
