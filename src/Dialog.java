import java.util.ArrayList;
import java.util.Scanner;

/**
 * ueb 14 - Dialogklasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Dialog {

    private ArrayList<Mitarbeiter> mitarbeiterliste;
    private ArrayList<Raum> raumliste;

    private Scanner input;

    /**
     * Konstruktur zum Initialisieren benötigter Elemente
     * 
     */

    public Dialog() {
        input = new Scanner(System.in);
        mitarbeiterliste = new ArrayList<Mitarbeiter>();
        raumliste = new ArrayList<Raum>();

    }

    public void start() {

    }

    /**
     * main Methode
     * 
     * @param args
     */
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

    /**
     * Menuepunkt Mitarbeiter anlegen
     * 
     * 
     */
    public void case1() {

        System.out.print("Vorname: ");
        String vorname = input.nextLine();
        System.out.print("\nNachname: ");
        String nachname = input.nextLine();
        System.out.print("\nE-Mail: ");
        String email = input.nextLine();

        Mitarbeiter mitarbeiter = new Mitarbeiter(vorname, nachname, email);
        this.mitarbeiterliste.add(mitarbeiter);
        System.out.println(String.format("%s wurde angelegt\n", mitarbeiter.toString()));

    }

    /**
     * Menuepunkt Raum anlegen
     * 
     * 
     */
    public void case2() {

        System.out.print("Gebäude: ");
        int gebäude = input.nextInt();
        System.out.print("\nEtage: ");
        int etage = input.nextInt();
        System.out.print("\nRaum: ");
        int raumNr = input.nextInt();

        Raum raum = new Raum(gebäude, etage, raumNr);
        raumliste.add(raum);
        System.out.print(String.format("%s wurde angelegt\n", raum.toString()));
        input.nextLine();

    }

    /**
     * Menuepunkt Raum reservieren
     * 
     * 
     */
    public void case3() {

        System.out.println("Raeume:");
        Lib_Dialog.printMenue(raumliste);
        int raumNr = Lib_Dialog.chooseOption();
        Raum raum = raumliste.get(Lib_Arrays.checkNullPointer(raumliste.toArray(), raumNr - 1));

        input.nextLine();
        System.out.println("Mitarbeiter:");
        Lib_Dialog.printMenue(mitarbeiterliste);
        int mitarbeiterNr = Lib_Dialog.chooseOption();
        Mitarbeiter mitarbeiter = mitarbeiterliste
                .get(Lib_Arrays.checkNullPointer(mitarbeiterliste.toArray(), raumNr - 1));

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

    /**
     * Menuepunkt Raum reservierungen anzeigen
     * 
     * 
     */
    public void case4() {
        Lib_Dialog.printMenue(raumliste);
    }

    /**
     * Menuepunkt Anazahl der Reservierungen anzeigen
     * 
     * 
     */
    public void case5() {

        for (Raum raum : raumliste) {

            System.out.println(String.format("Anzahl an Reservierungen: %d für %s", raum.getAnzahlReservierungen(),
                    raum.toString()));

        }

    }

}
