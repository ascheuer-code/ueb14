import java.util.ArrayList;
import java.util.Scanner;

/**
 * ueb 14 - Dialogklasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Dialog {

    private Raum raum;
    private Mitarbeiter mitarbeiter;
    private ArrayList<Mitarbeiter> mitarbeiterliste;
    private ArrayList<Raum> raumliste;
    private ArrayList<?> menue;
    private Scanner input;

    /**
     * @param args
     */

    public Dialog() {
        input = new Scanner(System.in);
        menue = new ArrayList<>();
        mitarbeiterliste = new ArrayList<Mitarbeiter>();
        raumliste = new ArrayList<Raum>();
    }

    public void start() {

    }

    public static void main(String[] args) {

        ArrayList<String> menue = new ArrayList<String>();

        menue.add("Mitarbeiter anlegen");
        menue.add("Raum anlegen");
        menue.add("Raum reservieren");
        menue.add("Raum reservierungen anzeigen");
        menue.add("Anzahl der reservierungen anzeigen");
        menue.add("Ende");

        new Lib_Dialog().start(menue);

    }

    public void case1() {

        System.out.print("Vorname: ");
        String vorname = input.nextLine();
        System.out.print("\nNachname: ");
        String nachname = input.nextLine();
        System.out.print("\nE-Mail: ");
        String email = input.nextLine();

        Mitarbeiter mitarbeiter = new Mitarbeiter(vorname, nachname, email);
        mitarbeiterliste.add(mitarbeiter);
        System.out.println(String.format("%s wurde angelegt", mitarbeiter.toString()));
        System.out.println();
    }

    public void case2() {

        System.out.print("Gebäude: ");
        int gebäude = input.nextInt();
        System.out.print("\nEtage: ");
        int etage = input.nextInt();
        System.out.print("\nRaum: ");
        int raumNr = input.nextInt();

        Raum raum = new Raum(gebäude, etage, raumNr);
        raumliste.add(raum);
        System.out.println(String.format("%s wurde angelegt", raum.toString()));
        System.out.println();
    }

    public void case3() {
        System.out.println("Raeume:");

        int raumNr = Lib_Dialog.einlesenFunktion(raumliste);
        Raum raum = raumliste.get(raumNr - 1);

        input.nextLine();
        System.out.println("Mitarbeiter:");

        int mitarbeiterNr = Lib_Dialog.einlesenFunktion(mitarbeiterliste);
        Mitarbeiter mitarbeiter = mitarbeiterliste.get(mitarbeiterNr - 1);

        System.out.print("\nBeginn Uhrzeit:");
        System.out.print("\nStunde:");
        int stundeBeginn = input.nextInt();
        System.out.print("\nMinute:");
        int minuteBeginn = input.nextInt();

        Uhrzeit beginn = new Uhrzeit(stundeBeginn, minuteBeginn);

        System.out.print("Ende Uhrzeit:\n");
        System.out.print("\nStunde:");
        int stundeEnde = input.nextInt();
        System.out.print("\nMinute:");
        int minuteEnde = input.nextInt();

        Uhrzeit ende = new Uhrzeit(stundeEnde, minuteEnde);

        input.nextLine();

        System.out.print("\nBemerkung:");
        String bemerkung = input.nextLine();

        mitarbeiter.reserviere(raum, beginn, ende, bemerkung);
    }

    public void case4() {
        Lib_Dialog.einlesenFunktion(raumliste);
    }

    public void case5() {

        for (Raum raum : raumliste) {

            System.out.println(String.format("Anzahl an Reservierungen: %d für %s", raum.getAnzahlReservierungen(),
                    raum.toString()));

        }

    }

}
