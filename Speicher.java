import java.util.ArrayList;

/**
 * Created by zeynel on 01.06.17.
 */
public class Speicher {
    int N=16; // Anzahl der Speicheradressen
    String[][] speicher = new String[N][2];

    final static ArrayList<Character> buchstabenListe = new ArrayList<>();
    final static ArrayList<Integer> zahlenListe = new ArrayList<>();
    final static Quersumme element = new Quersumme(buchstabenListe, zahlenListe);
    public int speicheradresse;

    public Speicher(String[][] speicher, int speichergröße){
        this.speicher = speicher;
        this.N = speichergröße;
    }

    void loadOrSave(String schlüssel, String wert, boolean parameter){
        int speicheradresse = element.getQuersumme(schlüssel)%(N-1);
        boolean kollision = false; // Variabel für Kollisionszustand
        String ab = null;
        int ziel, start; // Variabel für dynamisch Ziel&Startvergabe
        if(parameter==true){ab = schlüssel;}

        for(int a=0; a<1; a++) {
            if(a==0){ziel=N; start=speicheradresse;}
            else{ziel=speicheradresse; start=0;}
            for (int i = start; i < ziel; i++) {
                if (speicher[i][0] == schlüssel || speicher[i][0] == ab) {
                    if (parameter == true) { //LOAD
                        System.out.println("Speicheradresse(" + i + ")-->Schlüssel(" + schlüssel + ")-->Wert(" + speicher[i][1] + ")"); // Auslesevorgang
                    } else { //SAVE
                        System.out.println("In " + i + "te Speicherzelle gespeichert! Quersumme: " + speicheradresse);
                        speicher[i][0] = schlüssel;
                        speicher[i][1] = wert;
                    }
                    kollision = false; // keine Kollision
                    i = N; // Schleifen abbrechen
                } else {
                    kollision = true;
                }
            }
        }

        if(kollision==true){ // Abbruchbedingung falls Speicher voll ist oder ungültiger Schlüssel
            if(parameter==true) { // load
                System.out.println("\nERROR!: Beim Ladevorgang Schlüssel nicht gefunden oder Kollision konnte trotz Schutzmechanismus nicht verhindert werden!");
                System.out.println("Bitte erweitern Sie die Anzahl der Speicheradressen oder geben Sie einen gültigen Schlüssel ein...");
            }else{ // save
                System.out.println("Kollision konnte trotz Schutzmechanismus nicht verhindert werden!");
                System.out.println("Bitte erweitern Sie die Anzahl der Speicheradressen :)");}
        }
    }
}
