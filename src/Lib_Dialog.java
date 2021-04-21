import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lib_Dialog {

    private static final int ENDE = 0;
    private int option = -1;
    private Raum neuerRaum;
    private Mitarbeiter mitarbeiter;

    // private Arraylist<Mitarbeiter> mitarbeiterListe;

    private Scanner input;

    public Lib_Dialog() {
        input = new Scanner(System.in);

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

    public <T> int einlesenFunktion(ArrayList <T> arraylist) {

        StringBuilder sb = new StringBuilder();
        int optioncounter = 0;

        for (T string : arraylist) {

            optioncounter++;
            sb.append(String.format("%d: %s\n", optioncounter, string));

        }
        sb.append("\nBitte wählen sie eine Option\n");
        System.out.print(sb);

        return input.nextInt();

    }


    public void ausfuehrenFunktion(int option) {

        switch (option) {
        case 0: 
            System.out.println("Ende");
        case 1:
            mitarbeiterAnlegen();
        case 2:
            raumAnlegen();
        case 3:
            raumReservieren();
        case 4:
            reservierungenAnzeigen();
        case 5:
            anzahlReservierungenAnzeigen();

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

        Mitarbeiter m = new Mitarbeiter(vorname, nachname, email);
        m.addMitarbeiter(m);
        System.out.println(String.format("%s wurde angelegt", m.toString()));
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
        neuerRaum.addRaum(neuerRaum);
        System.out.println(String.format("%s wurde angelegt", neuerRaum.toString()));
        System.out.println();
    }

    public void raumReservieren() {
        input.nextLine();
        System.out.println("Raeume:");

        int raumNr = einlesenFunktion(new Raum().getRaumListe());        
        Raum raum = neuerRaum.getRaumListe().get(raumNr - 1);

        input.nextLine();
        System.out.println("Mitarbeiter:");

        int mitarbeiterNr = einlesenFunktion(mitarbeiter.getMitarbeiterListe());        
        Mitarbeiter neuerMitarbeiter = mitarbeiter.getMitarbeiterListe().get(mitarbeiterNr - 1);

        System.out.print("Beginn Uhrzeit:\n");
        System.out.print("Stunde:\n");
        int stundeBeginn = input.nextInt();
        System.out.print("Minute:\n");
        int minuteBeginn = input.nextInt();

        Uhrzeit beginn = new Uhrzeit(stundeBeginn, minuteBeginn);
        
        System.out.print("Ende Uhrzeit:\n");
        System.out.print("\nStunde:");
        int stundeEnde = input.nextInt();
        System.out.print("\nMinute:\n");
        int minuteEnde = input.nextInt();

        Uhrzeit ende = new Uhrzeit(stundeEnde, minuteEnde);
        
        System.out.print("\nBemerkung:");
        String bemerkung = input.nextLine();
        
        
        neuerMitarbeiter.reserviere(raum, beginn, ende, bemerkung);
    }

    public void reservierungenAnzeigen() {

         neuerRaum.getReservierungsListe().toArray();    
            
        
    }

    public void anzahlReservierungenAnzeigen() {
        System.out.println("Anzahl der Reservierungen: " + neuerRaum.getAnzahlReservierungen());
        System.out.println();
    }
}
