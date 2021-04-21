import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private static final int ENDE = 0;
    private int option = -1;
    private Raum neuerRaum;
    private Mitarbeiter mitarbeiter;
    private ArrayList<Mitarbeiter> mitarbeiterliste;
    private ArrayList<Raum> raeume;
    private ArrayList<?> menue;

    // private Arraylist<Mitarbeiter> mitarbeiterListe;

    private Scanner input;

    public <T> Lib_Dialog(ArrayList<T> menue) {
        input = new Scanner(System.in);

        menue = new ArrayList<T>(menue);
        mitarbeiterliste = new ArrayList<Mitarbeiter>();
        raeume = new ArrayList<Raum>();

    }

    /**
     * Eigentliche Startmethode
     */

    public void start(ArrayList<String> menue) {

        while (option != ENDE) {
            try {
                option = einlesenFunktion(menue);
                ausfuehrenFunktion(option);
            } catch (IllegalArgumentException msg) {
                System.out.println("\n" + msg);
            } catch (InputMismatchException msg) {
                System.out.println("\n" + msg + ": Kein korrekter Wert");
                input.nextLine();
            } catch (Exception msg) {
                System.out.println("\n" + msg);
            }
        }
    }

    public <T> int einlesenFunktion(ArrayList<T> arraylist) {

        StringBuilder sb = new StringBuilder();
        int optioncounter = 0;

        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        sb.append("\nBitte wählen sie eine Option\n");
        System.out.print(sb);

        if (arraylist.equals(raeume)) {
            return 1;
        }
        return input.nextInt();

    }

    public void ausfuehrenFunktion(int option) {

        switch (option) {
        case 0:
            System.out.println("Ende");
            break;
        case 1:
            mitarbeiterAnlegen();
            break;
        case 2:
            raumAnlegen();
            break;
        case 3:
            raumReservieren();
            break;
        case 4:
            reservierungenAnzeigen();
            break;
        case 5:
            anzahlReservierungenAnzeigen();
            break;

        }

    }

    public void mitarbeiterAnlegen() {
        input.nextLine();
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

    public void raumAnlegen() {
        input.nextLine();
        System.out.print("Gebäude: ");
        int gebäude = input.nextInt();
        System.out.print("\nEtage: ");
        int etage = input.nextInt();
        System.out.print("\nRaum: ");
        int raum = input.nextInt();

        Raum neuerRaum = new Raum(gebäude, etage, raum);
        raeume.add(neuerRaum);
        System.out.println(String.format("%s wurde angelegt", neuerRaum.toString()));
        System.out.println();
    }

    public void raumReservieren() {
        input.nextLine();
        System.out.println("Raeume:");

        int raumNr = einlesenFunktion(raeume);
        Raum raum = raeume.get(raumNr - 1);

        input.nextLine();
        System.out.println("Mitarbeiter:");

        int mitarbeiterNr = einlesenFunktion(mitarbeiterliste);
        Mitarbeiter mitarbeiter = mitarbeiterliste.get(mitarbeiterNr - 1);

        System.out.print("\nBeginn Uhrzeit:");
        System.out.print("\n1Stunde:");
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

    public void reservierungenAnzeigen() {

        einlesenFunktion(raeume);

    }

    public void anzahlReservierungenAnzeigen() {
        for (Raum raum : raeume) {

            System.out.println(String.format("Anzahl an Reservierungen:%d für %s", raum.getAnzahlReservierungen(),
                    raum.toString()));

        }
    }
}
